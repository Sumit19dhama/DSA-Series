class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
         Map<Integer, Integer> freq = new HashMap<>();
        long maxSum = 0, windowSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            windowSum += num;

            if (right - left + 1 > k) {
                int leftNum = nums[left];
                freq.put(leftNum, freq.get(leftNum) - 1);
                if (freq.get(leftNum) == 0) freq.remove(leftNum);
                windowSum -= leftNum;
                left++;
            }

            if (right - left + 1 == k && freq.size() == k) {
                maxSum = Math.max(maxSum, windowSum);
            }
        }

        return maxSum;
    }
}