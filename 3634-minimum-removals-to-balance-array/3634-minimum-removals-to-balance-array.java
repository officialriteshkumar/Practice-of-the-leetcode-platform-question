class Solution {
    public int minRemoval(int[] nums, int k) {


        Arrays.sort(nums);
        int n = nums.length;

        int left = 0;

        int maxLen = 1;

        for(int i = 0; i < n; i++){
            while((long) nums[i]> (long) nums[left] *k){

            
            left++;
        }
        maxLen = Math.max(maxLen,i-left+1);
        
    }

    return n- maxLen;

    }
}