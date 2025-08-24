class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int start = 0; start <= n - k; start++) {
            boolean isConsecutive = true;

            for (int j = start + 1; j < start + k; j++) {
                if (nums[j] != nums[j - 1] + 1) {
                    isConsecutive = false;
                    break;
                }
            }

            if (isConsecutive) {
                result[start] = nums[start + k - 1]; 
            } else {
                result[start] = -1;
            }
        }

        return result;
    }
}