class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
         int m = rowSum.length;
    int n = colSum.length;
    int[][] ans = new int[m][n];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (rowSum[i] == 0 || colSum[j] == 0) continue;
            int now = Math.min(rowSum[i], colSum[j]);
            ans[i][j] = now;
            rowSum[i] -= now;
            colSum[j] -= now;
        }
    }
    return ans;
    }
}