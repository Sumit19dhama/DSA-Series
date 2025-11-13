class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] count = new int[len][2]; // count[i][0] = zeros, count[i][1] = ones

        // Count zeros and ones for each string
        for (int i = 0; i < len; i++) {
            int zeros = 0, ones = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }
            count[i][0] = zeros;
            count[i][1] = ones;
        }

        // dp[index][m][n] = max subset size from index with m zeros and n ones left
        int[][][] dp = new int[len][m + 1][n + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(0, m, n, count, dp);
    }

    private int solve(int idx, int m, int n, int[][] count, int[][][] dp) {
        // Base case
        if (idx == count.length) return 0;
        if (dp[idx][m][n] != -1) return dp[idx][m][n];

        // Option 1: skip current string
        int notTake = solve(idx + 1, m, n, count, dp);

        // Option 2: take current string (if possible)
        int take = 0;
        int zeros = count[idx][0];
        int ones = count[idx][1];
        if (m >= zeros && n >= ones) {
            take = 1 + solve(idx + 1, m - zeros, n - ones, count, dp);
        }

        return dp[idx][m][n] = Math.max(take, notTake);
    }
}