package Ritesh;

    class Solution {
        public int subsetXORSum(int[] nums) {
            return dfs(nums, 0, 0);
        }
    
        private int dfs(int[] nums, int index, int currentXor) {
            if (index == nums.length) {
                return currentXor;
            }
            int include = dfs(nums, index + 1, currentXor ^ nums[index]);
            int exclude = dfs(nums, index + 1, currentXor);
            return include + exclude;
        }
    
        public static void main(String[] args) {
            Solution solution = new Solution();
            
            int[] nums1 = {1, 3};
            System.out.println(solution.subsetXORSum(nums1)); 
    
            int[] nums2 = {5, 1, 6};
            System.out.println(solution.subsetXORSum(nums2)); 
    
            int[] nums3 = {3, 4, 5, 6, 7, 8};
            System.out.println(solution.subsetXORSum(nums3)); 
        }
    }
    
    
