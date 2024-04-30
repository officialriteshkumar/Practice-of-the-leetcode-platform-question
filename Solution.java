package Ritesh;

public class Solution {
    public long wonderfulSubstrings(String word) {
        int[] count = new int[1024]; 
        count[0] = 1;
        long result = 0;
        int mask = 0;

        for (char c : word.toCharArray()) {
            mask ^= 1 << (c - 'a'); 
            result += count[mask];
            for (int i = 0; i < 10; i++) {
                result += count[mask ^ (1 << i)];
            }
            count[mask]++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String word = "aba";
        System.out.println(solution.wonderfulSubstrings(word));
    }
}
