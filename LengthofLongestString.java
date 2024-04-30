package Ritesh;

import java.util.ArrayList;
import java.util.List;

public class LengthofLongestString {
    class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        for(int i=0; i<s.length(); i++){
            List<Character> temp = new ArrayList<>();
            int t=0;
            for(char c : s.substring(i).toCharArray()){
                if(temp.contains(c)){
                    break;
                }
                temp.add(c);
                t++;
            }
            ans = Math.max(ans, t);
        }
        return ans;
    }
}
    
}
