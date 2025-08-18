class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> {
                int distA = Math.abs(a - x);
                int distB = Math.abs(b - x);
                if (distA == distB) return b - a; // if tie, remove larger one first
                return distB - distA; // max-heap by distance
            }
        );

        for (int num : arr) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Extract elements
        List<Integer> result = new ArrayList<>(heap);
        Collections.sort(result); // required: ascending order
        return result;
    }
}