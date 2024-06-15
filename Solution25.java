class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
         int n = profits.length;
        Project[] projects = new Project[n];
        
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(profits[i], capital[i]);
        }
        Arrays.sort(projects, (a, b) -> Integer.compare(a.capital, b.capital));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        int currentIndex = 0;
        for (int i = 0; i < k; i++) {
            while (currentIndex < n && projects[currentIndex].capital <= w) {
                maxHeap.add(projects[currentIndex].profit);
                currentIndex++;
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll();
        }
        
        return w;
    }
    static class Project {
        int profit;
        int capital;

        Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}