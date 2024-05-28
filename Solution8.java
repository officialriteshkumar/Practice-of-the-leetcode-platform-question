package Ritesh;
    class Solution {
        public int equalSubstring(String s, String t, int maxCost) {
           int maxLength = 0;
            int currentCost = 0;
            int start = 0;
    
            for (int end = 0; end < s.length(); end++) {
                currentCost += Math.abs(s.charAt(end) - t.charAt(end));
    
                while (currentCost > maxCost) {
                    currentCost -= Math.abs(s.charAt(start) - t.charAt(start));
                    start++;
                }
    
                maxLength = Math.max(maxLength, end - start + 1);
            }
    
            return maxLength;
        }
    
        public static void main(String[] args) {
            Solution solution = new Solution();
    
            System.out.println(solution.equalSubstring("abcd", "bcdf", 3));
            System.out.println(solution.equalSubstring("abcd", "cdef", 3));
            System.out.println(solution.equalSubstring("abcd", "acde", 0));  
        }
    }
    
}
