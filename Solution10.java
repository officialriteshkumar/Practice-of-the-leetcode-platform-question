
    class Solution {
        public int countTriplets(int[] arr) {
            int n = arr.length;
            int count = 0;
            
            for (int i = 0; i < n - 1; i++) {
                int xor = arr[i];
                for (int k = i + 1; k < n; k++) {
                    xor ^= arr[k];
                    if (xor == 0) {
                        count += (k - i);
                    }
                }
            }
            
            return count;
        }
        
        public static void main(String[] args) {
            Solution solution = new Solution();
            
            int[] arr1 = {2, 3, 1, 6, 7};
            int[] arr2 = {1, 1, 1, 1, 1};
            
            System.out.println(solution.countTriplets(arr1)); 
            System.out.println(solution.countTriplets(arr2)); 
        }
    }
    
    

