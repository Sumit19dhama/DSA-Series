class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long count = 0;   
        long pairs = 0;   
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            pairs += freq.getOrDefault(num, 0);
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            while (pairs >= k) {
                count += (nums.length - right);
                int leftNum = nums[left];
                freq.put(leftNum, freq.get(leftNum) - 1);
                pairs -= freq.get(leftNum); 
                left++;
            }
        }

        return count;
    }
}