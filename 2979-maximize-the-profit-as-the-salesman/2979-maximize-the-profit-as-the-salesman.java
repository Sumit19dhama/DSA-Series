class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
         int[] dp = new int[n + 1];

        List<List<int[]>> byEnd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            byEnd.add(new ArrayList<>());
        }

        for (List<Integer> offer : offers) {
            int start = offer.get(0);
            int end   = offer.get(1);
            int gold  = offer.get(2);
            byEnd.get(end).add(new int[]{start, gold});
        }

        for (int i = 1; i <= n; i++) {
            // Option 1: skip house i-1
            dp[i] = dp[i - 1];

            // Option 2: take an offer ending at house i-1
            for (int[] offer : byEnd.get(i - 1)) {
                int start = offer[0], gold = offer[1];
                dp[i] = Math.max(dp[i], dp[start] + gold);
            }
        }

        return dp[n];
    }
}