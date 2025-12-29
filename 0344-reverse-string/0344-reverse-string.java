class Solution {
    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        
        while (i < j) {
            char r = s[i];
            s[i] = s[j];
            s[j] = r;
            
            i++;
            j--;
        }
    }
}
