class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        if (n < 2) return 0;

        // Step 1: Compute length of increasing subarray ending at i
        int[] inc = new int[n];
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 1;
            }
        }

        // Step 2: Compute length of increasing subarray starting at i
        int[] incFrom = new int[n];
        incFrom[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                incFrom[i] = incFrom[i + 1] + 1;
            } else {
                incFrom[i] = 1;
            }
        }

        // Step 3: Find max k such that two adjacent increasing subarrays of length k exist
        int maxK = 0;
        for (int i = 0; i < n - 1; i++) {
            int leftLen = inc[i];
            int rightLen = incFrom[i + 1];
            int k = Math.min(leftLen, rightLen);
            maxK = Math.max(maxK, k);
        }

        return maxK;
    }
}