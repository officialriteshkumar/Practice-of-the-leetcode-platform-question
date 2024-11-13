import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int low = lowerBound(nums, i + 1, nums.length, lower - nums[i]);
            int up = upperBound(nums, i + 1, nums.length, upper - nums[i]);
            ans += up - low;
        }
        return ans;
    }
  
    private int lowerBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    private int upperBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) end = mid;
            else start = mid + 1;
        }
        return start;
    }
}
