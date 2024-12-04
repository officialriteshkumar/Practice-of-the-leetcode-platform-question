class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int srcIdx = 0, tgtIdx = 0;
        int srcLen = str1.length(), tgtLen = str2.length();
        
        while (srcIdx < srcLen && tgtIdx < tgtLen) {
            char srcChar = str1.charAt(srcIdx);
            char targetChar = str2.charAt(tgtIdx);
            
        
            if (srcChar == targetChar || 
                (char)(srcChar + 1) == targetChar || 
                (srcChar == 'z' && targetChar == 'a')) {
                tgtIdx++; 
                            }
            
            srcIdx++;
                   }
        
        
        return tgtIdx == tgtLen;
    }
}
