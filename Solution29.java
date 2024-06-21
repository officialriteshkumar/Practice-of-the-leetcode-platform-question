class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int totalSatisfied = 0;
        int maxAdditionalSatisfied = 0;
        int currentAdditionalSatisfied = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            }
        }
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                currentAdditionalSatisfied += customers[i];
            }
        }
        maxAdditionalSatisfied = currentAdditionalSatisfied;
        for (int i = minutes; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                currentAdditionalSatisfied += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                currentAdditionalSatisfied -= customers[i - minutes];
            }
            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, currentAdditionalSatisfied);
        }
        
        return totalSatisfied + maxAdditionalSatisfied;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));  
        System.out.println(sol.maxSatisfied(new int[]{1}, new int[]{0}, 1)); 
    }
}