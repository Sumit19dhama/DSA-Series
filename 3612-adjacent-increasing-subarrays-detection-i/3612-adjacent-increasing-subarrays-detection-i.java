class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (n < 2 * k) return false; // Need at least 2k elements

        // inc[i] = true if nums[i..i+k-1] is strictly increasing
        boolean[] inc = new boolean[n - k + 1];

        // Compute increasing subarrays
        for (int i = 0; i <= n - k; i++) {
            boolean strictlyIncreasing = true;
            for (int j = i; j < i + k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    strictlyIncreasing = false;
                    break;
                }
            }
            inc[i] = strictlyIncreasing;
        }

        // Check for two adjacent increasing subarrays
        for (int i = 0; i + k < inc.length; i++) {
            if (inc[i] && inc[i + k]) {
                return true;
            }
        }

        return false;
    }
}