class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }
        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            minDifference = Math.min(minDifference, nums[n - 1 - (3 - i)] - nums[i]);
        }

        return minDifference;
    } 
    }
