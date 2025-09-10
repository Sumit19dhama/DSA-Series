class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOne = 0,maxCount = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 1){
                maxCount++;
                maxOne = Math.max(maxOne, maxCount);
            }else{
                maxCount = 0;
            }
        }
        return maxOne;
    }
}