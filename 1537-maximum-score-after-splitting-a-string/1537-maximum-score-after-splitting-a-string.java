class Solution {
    public int maxScore(String s) {
        int n = s.length(); // Corrected 'nt' to 'int'
        int ones = 0; 

        // Count the number of '1's in the string
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        int zeros = 0; 
        int maxScore = 0;

        // Iterate through the string up to the second-to-last character
        for (int i = 0; i < n - 1; i++) { 
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones--;
            }
            maxScore = Math.max(maxScore, zeros + ones);
        }

        return maxScore;
    }
}
