
    
 class Solution {
    public static int longestPalindrome(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean oddCountFound = false;
        for (int count : charCountMap.values()) {
            if (count % 2 == 0) {
                length += count; 
            } else {
                length += count - 1; 
                oddCountFound = true;
            }
        }

        
        if (oddCountFound) {
            length++;
        }

        return length;
    }

    public static void main(String[] args) {
        String s1 = "abccccdd";
        System.out.println("Input: " + s1 + "\nOutput: " + longestPalindrome(s1)); 
        String s2 = "a";
        System.out.println("Input: " + s2 + "\nOutput: " + longestPalindrome(s2)); 

        String s3 = "bb";
        System.out.println("Input: " + s3 + "\nOutput: " + longestPalindrome(s3)); 
    }
}

