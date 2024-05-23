package Ritesh;

import java.util.ArrayList;
import java.util.List;
    class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), allSubsets);

        int count = 0;
        for (List<Integer> subset : allSubsets) {
            if (isBeautifulSubset(subset, k)) {
                count++;
            }
        }
        return count;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> allSubsets) {
        if (index == nums.length) {
            if (!current.isEmpty()) {
                allSubsets.add(new ArrayList<>(current));
            }
            return;
        }
        current.add(nums[index]);
        generateSubsets(nums, index + 1, current, allSubsets);
        current.remove(current.size() - 1);
        generateSubsets(nums, index + 1, current, allSubsets);
    }

    private boolean isBeautifulSubset(List<Integer> subset, int k) {
        for (int i = 0; i < subset.size(); i++) {
            for (int j = i + 1; j < subset.size(); j++) {
                if (Math.abs(subset.get(i) - subset.get(j)) == k) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {2, 4, 6};
        int k1 = 2;
        System.out.println(solution.beautifulSubsets(nums1, k1)); 

        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(solution.beautifulSubsets(nums2, k2));  
    }
}

