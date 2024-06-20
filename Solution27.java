class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int left = 1; 
        int right = position[position.length - 1] - position[0];  
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (canPlaceBalls(position, m, mid)) {
                left = mid;  
            } else {
                right = mid - 1; 
            }
        }
        
        return left;
    }
    
    private boolean canPlaceBalls(int[] position, int m, int minDist) {
        int count = 1;  // 
        int lastPosition = position[0];
        
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= minDist) {
                count++;
                lastPosition = position[i];
                if (count == m) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxDistance(new int[]{1, 2, 3, 4, 7}, 3)); 
        System.out.println(sol.maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));  
    }
}

