package Ritesh;

import java.util.Arrays;
    class Solution {
    public int specialArray(int[] nums) {
        return findSpecialX(nums);
    }

    public static int findSpecialX(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for (int x = 0; x <= n; x++) {
            int count = 0;
            for (int num : nums) {
                if (num >= x) {
                    count++;
                }
            }

            if (count == x) {
                return x;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] nums1 = {3, 5};
        int[] nums2 = {0, 0};
        int[] nums3 = {0, 4, 3, 0, 4};

        System.out.println(sol.specialArray(nums1)); // Output: 2
        System.out.println(sol.specialArray(nums2)); // Output: -1
        System.out.println(sol.specialArray(nums3)); // Output: 3
    }
}
    