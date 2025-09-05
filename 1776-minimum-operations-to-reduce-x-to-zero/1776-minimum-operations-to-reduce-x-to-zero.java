class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }

        int targetSum = totalSum - x;
        if (targetSum < 0) {
            return -1;
        } 
        if (targetSum == 0){
            return n;
        } 

        int left = 0;
        int sum = 0, maxLen = -1;
        for(int right = 0; right < n; right++){
            sum += nums[right];

            while(sum > targetSum && left <= right){
                sum -= nums[left++];
            }

            if(sum == targetSum){
                maxLen = Math.max(maxLen, right - left + 1);
            }
        } 

        return (maxLen == -1) ? -1 : n - maxLen;
    }
}