class Solution {
    public int numWays(String s) {
        final int MOD = 1_000_000_007;
        int n = s.length();
        long totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        // Case 1: no ones
        if (totalOnes == 0) {
            long ways = ((long)(n - 1) * (n - 2) / 2) % MOD;
            return (int) ways;
        }

        // Case 2: not divisible by 3
        if (totalOnes % 3 != 0) return 0;

        // Case 3: divisible by 3
        long target = totalOnes / 3;
        long ways1 = 0, ways2 = 0;
        long count = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') count++;
            if (count == target) ways1++;
            if (count == 2 * target) ways2++;
        }

        return (int)((ways1 * ways2) % MOD);
    }
}