class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums); // Step 1: sort

        int i = 0;
        // Step 2: flip negatives while we can
        while (i < nums.length && k > 0 && nums[i] < 0) {
            nums[i] = -nums[i];
            k--;
            i++;
        }

        // Step 3: if k is still positive and odd, flip smallest absolute value
        Arrays.sort(nums); // re-sort to find smallest
        if (k % 2 == 1) {
            nums[0] = -nums[0];
        }

        // Step 4: sum and return
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}