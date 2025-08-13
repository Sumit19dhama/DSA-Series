class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num); // Add number to heap
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest to keep only k largest
            }
        }

        return minHeap.peek();
    }
}