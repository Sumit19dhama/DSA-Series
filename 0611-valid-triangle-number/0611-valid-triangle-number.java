class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;

        for (int k = n - 1; k >= 2; k--) { // k is the largest side index
            int left = 0, right = k - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[k]) {
                    // All elements between left and right-1 will also work
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }

        return count;
    }
}