class Solution {
    public int minAddToMakeValid(String s) {
        int unmatchedLeft = 0; 
        int unmatchedRight = 0; 
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                unmatchedLeft++; 
            } else {
                if (unmatchedLeft > 0) {
                    unmatchedLeft--; 
                } else {
                    unmatchedRight++;
                }
            }
        }
        return unmatchedLeft + unmatchedRight;
    }
}
