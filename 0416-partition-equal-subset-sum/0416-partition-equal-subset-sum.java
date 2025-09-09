class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }

        int target = sum/2;

        return isPossible(nums, target);
    }
    private boolean isPossible(int[] nums, int k){
        int n = nums.length;
        Boolean[][] dp = new Boolean[n][k+1];

        return helper(n-1, k, nums, dp);
    }

    private boolean helper(int idx, int target, int[] nums, Boolean[][] dp){
        if(target == 0){
            return true;
        }
        if(idx == 0){
            return nums[0] == target;
        }
        if(dp[idx][target] != null){
            return dp[idx][target];
        }

        boolean notTake = helper(idx - 1, target, nums, dp);
        boolean take = false;
        if(target >= nums[idx]){
            take = helper(idx - 1, target -nums[idx], nums, dp);
        }

        return dp[idx][target] = take || notTake;
    }
}