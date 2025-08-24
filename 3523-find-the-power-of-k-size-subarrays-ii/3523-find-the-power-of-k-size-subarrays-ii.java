class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int[] dp = new int[n];
        
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        
        for (int i = k - 1; i < n; i++) {
            if (dp[i] >= k) {
                result[i - k + 1] = nums[i]; 
            } else {
                result[i - k + 1] = -1;
            }
        }
        
        return result;
    }
}