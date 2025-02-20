import java.util.HashSet;
import java.util.Set;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> numSet = new HashSet<>();
        for (String num : nums) {
            numSet.add(num);
        }

        return generateBinary("", n, numSet);
    }

    private String generateBinary(String binary, int n, Set<String> numSet) {
        if (binary.length() == n) {
            if (!numSet.contains(binary)) {
                return binary;
            }
            return null;
        }

        String result = generateBinary(binary + '0', n, numSet);
        if (result != null) return result;

        return generateBinary(binary + '1', n, numSet);
    }
}
