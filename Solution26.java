public class Solution26 {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) {
            return -1;
        }
        
        int left = 1;
        int right = 0;
        for (int day : bloomDay) {
            right = Math.max(right, day);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return canMakeBouquets(bloomDay, m, k, left) ? left : -1;
    }
    
    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;
        
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        
        return bouquets >= m;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minDays(new int[]{1,10,3,10,2}, 3, 1));  
        System.out.println(sol.minDays(new int[]{1,10,3,10,2}, 3, 2));  
        System.out.println(sol.minDays(new int[]{7,7,7,7,12,7,7}, 2, 3)); 
    }
}

