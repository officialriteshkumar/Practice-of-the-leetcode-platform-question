class Solution {
    public int[] sortArray(int[] nums) {
        
  Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {5, 2, 3, 1};
        System.out.println(Arrays.toString(sol.sortArray(nums1)));
        int[] nums2 = {5, 1, 1, 2, 0, 0};
        System.out.println(Arrays.toString(sol.sortArray(nums2)));
            }
}
