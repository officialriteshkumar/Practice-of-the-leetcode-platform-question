package Ritesh;

import java.util.HashMap;
import java.util.Map;

public class MaxScoreWord {
    
    static class Solution {

        public int maxScoreWords(String[] words, char[] letters, int[] score) {
            Map<Character, Integer> letterCount = new HashMap<>();
            for (char letter : letters) {
                letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
            }

            return backtrack(words, letterCount, score, 0);
        }

        private int backtrack(String[] words, Map<Character, Integer> letterCount, int[] score, int index) {
            if (index == words.length) {
                return 0;
            }
            int maxScore = backtrack(words, letterCount, score, index + 1);
            String word = words[index];
            boolean canFormWord = true;
            int wordScore = 0;
            Map<Character, Integer> tempCount = new HashMap<>(letterCount);

            for (char c : word.toCharArray()) {
                if (tempCount.getOrDefault(c, 0) > 0) {
                    tempCount.put(c, tempCount.get(c) - 1);
                    wordScore += score[c - 'a'];
                } else {
                    canFormWord = false;
                    break;
                }
            }

            if (canFormWord) {
                wordScore += backtrack(words, tempCount, score, index + 1);
                maxScore = Math.max(maxScore, wordScore);
            }

            return maxScore;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();

            String[] words1 = {"dog", "cat", "dad", "good"};
            char[] letters1 = {'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
            int[] score1 = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            System.out.println(solution.maxScoreWords(words1, letters1, score1)); // Output: 23

            String[] words2 = {"xxxz", "ax", "bx", "cx"};
            char[] letters2 = {'z', 'a', 'b', 'c', 'x', 'x', 'x'};
            int[] score2 = {4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10};
            System.out.println(solution.maxScoreWords(words2, letters2, score2)); // Output: 27

            String[] words3 = {"leetcode"};
            char[] letters3 = {'l', 'e', 't', 'c', 'o', 'd'};
            int[] score3 = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0};
            System.out.println(solution.maxScoreWords(words3, letters3, score3)); // Output: 0
        }
    }
}
