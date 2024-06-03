
    class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.appendCharacters("coaching", "coding")); 
            System.out.println(solution.appendCharacters("abcde", "a"));
            System.out.println(solution.appendCharacters("z", "abcde")); 
        }
    
        public int appendCharacters(String s, String t) {
            int m = s.length();
            int n = t.length();
    
            int i = 0, j = 0;
            while (i < m && j < n) {
                if (s.charAt(i) == t.charAt(j)) {
                    j++; 
                }
                i++; 
            }
    
            
            if (j == n) {
                return 0;
            } else {
                return n - j; 
            }
        }
    }
    
    

