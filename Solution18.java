
    
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k == 0) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0 && nums[i+1] == 0) {
                    return true;
                }
            }
            return false;
        }
        Map<Integer, Integer> remainderDict = new HashMap<>();
        remainderDict.put(0, -1); 
        
        int cumulativeSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];
            int remainder = cumulativeSum % k;
            if (remainder < 0) {
                remainder += k;
            }
            
            if (remainderDict.containsKey(remainder)) {
                if (i - remainderDict.get(remainder) > 1) {
                    return true;
                }
            } else {
                remainderDict.put(remainder, i);
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println(solution.checkSubarraySum(nums1, k1)); 
        
        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 6;
        System.out.println(solution.checkSubarraySum(nums2, k2)); 
        
        int[] nums3 = {23, 2, 6, 4, 7};
        int k3 = 13;
        System.out.println(solution.checkSubarraySum(nums3, k3));
    }
}
