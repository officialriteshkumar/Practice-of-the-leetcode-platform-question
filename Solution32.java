class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] isFlipped = new int[n];
        int flipCount = 0, result = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flipCount ^= isFlipped[i - k];
            }

            if ((nums[i] ^ flipCount) == 0) {
                if (i + k > n) {
                    return -1;
                }
                result++;
                flipCount ^= 1;
                if (i < n) {
                    isFlipped[i] = 1;
                }
            }
        }

        return result;
    } 
    }
