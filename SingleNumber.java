import java.util.Arrays;
    class Solution {
    public int[] singleNumber(int[] nums) {
         int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int diff = xor & (-xor);
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {1, 2, 1, 3, 2, 5};
        int[] result1 = solution.singleNumber(nums1);
        System.out.println(Arrays.toString(result1)); 

        int[] nums2 = {-1, 0};
        int[] result2 = solution.singleNumber(nums2);
        System.out.println(Arrays.toString(result2)); 

        int[] nums3 = {0, 1};
        int[] result3 = solution.singleNumber(nums3);
        System.out.println(Arrays.toString(result3));
    }
}
    

