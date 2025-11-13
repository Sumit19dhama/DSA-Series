class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // Step 1: If any element is already 1
        int ones = 0;
        for (int num : nums) {
            if (num == 1) ones++;
        }
        if (ones > 0) return n - ones; // each non-1 becomes 1 using an existing 1

        // Step 2: Check if gcd of all elements > 1 → impossible
        int overallGcd = nums[0];
        for (int num : nums) {
            overallGcd = gcd(overallGcd, num);
        }
        if (overallGcd > 1) return -1;

        // Step 3: Find smallest subarray with gcd == 1
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break; // no need to extend further, gcd won't get smaller
                }
            }
        }

        // Step 4: Total operations = (minLen - 1) to create 1 + (n - 1) to spread 1
        return (minLen - 1) + (n - 1);
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}