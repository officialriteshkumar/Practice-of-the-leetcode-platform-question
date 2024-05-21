package Ritesh;

import java.util.ArrayList;
import java.util.List;

public class Subset2 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> subsets1 = subsets(nums1);
        System.out.println("Subsets 1: " + subsets1);

        int[] nums2 = {0};
        List<List<Integer>> subsets2 = subsets(nums2);
        System.out.println("Subsets 2: " + subsets2);
    }
}
    
