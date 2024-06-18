class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
         int n = difficulty.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, new Comparator<Job>() {
            public int compare(Job a, Job b) {
                if (a.difficulty == b.difficulty) {
                    return b.profit - a.profit;
                }
                return a.difficulty - b.difficulty;
            }
        });
        Arrays.sort(worker);
        
        int maxProfit = 0;
        int i = 0;
        int bestProfit = 0;
        for (int ability : worker) {
            while (i < n && ability >= jobs[i].difficulty) {
                bestProfit = Math.max(bestProfit, jobs[i].profit);
                i++;
            }
            maxProfit += bestProfit;
        }
        
        return maxProfit;
    }
    
    static class Job {
        int difficulty;
        int profit;

        Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
    }
}
}