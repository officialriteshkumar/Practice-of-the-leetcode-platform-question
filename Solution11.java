
    class Solution {
        public int scoreOfString(String s) {
            int score = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                score += Math.abs(s.charAt(i) - s.charAt(i + 1));
            }
            return score;
        }
    
        public static void main(String[] args) {
            Solution solution = new Solution();
            
            String s1 = "hello";
            int score1 = solution.scoreOfString(s1);
            System.out.println("The score of the string \"" + s1 + "\" is: " + score1);
            
            String s2 = "zaz";
            int score2 = solution.scoreOfString(s2);
            System.out.println("The score of the string \"" + s2 + "\" is: " + score2); 
        }
    }
    
