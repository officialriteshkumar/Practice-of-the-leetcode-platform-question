package Ritesh;
    class Solution {
        static final int MOD = 1000000007;
    
        public int checkRecord(int n) {
            if (n == 0) return 0;
            if (n == 1) return 3;
    
             int[][][] dp = new int[n + 1][2][3];
            dp[0][0][0] = 1;
    
            for (int i = 1; i <= n; i++) {
                for (int a = 0; a <= 1; a++) {
                    for (int l = 0; l <= 2; l++) {
                        dp[i][a][0] = (dp[i][a][0] + dp[i - 1][a][l]) % MOD;
                    }
                }
                for (int a = 0; a <= 1; a++) {
                    for (int l = 1; l <= 2; l++) {
                        dp[i][a][l] = (dp[i][a][l] + dp[i - 1][a][l - 1]) % MOD;
                    }
                }
                for (int l = 0; l <= 2; l++) {
                    dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][l]) % MOD;
                }
            }
            int result = 0;
            for (int a = 0; a <= 1; a++) {
                for (int l = 0; l <= 2; l++) {
                    result = (result + dp[n][a][l]) % MOD;
                }
            }
    
            return result;
        }
        public static void main(String[] args) {
            Solution sol = new Solution();
            int n = 10101; 
            System.out.println(sol.checkRecord(n));
        }
    }
    
    
}
