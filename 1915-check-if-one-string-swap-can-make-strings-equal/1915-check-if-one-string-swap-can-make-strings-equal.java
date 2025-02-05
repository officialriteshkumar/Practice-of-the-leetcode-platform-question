class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int first = -1, second = -1;
        char[] arr = s1.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != s2.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false; // More than two mismatches
                }
            }
        }

        if (first == -1) return true; // Already equal
        if (second == -1) return false; // Only one mismatch

        // Swap the characters and check if they match
        char temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;

        return String.valueOf(arr).equals(s2);
    }
}
