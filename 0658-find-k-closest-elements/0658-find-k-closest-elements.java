class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;

        // Binary search to find best starting index
        while (left < right) {
            int mid = (left + right) / 2;
            // Compare distances
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1; // closer window is to the right
            } else {
                right = mid;    // closer window is to the left or here
            }
        }

        // Build result from window [left, left + k)
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
        
        
        
        
        
        // PriorityQueue<Integer> heap = new PriorityQueue<>(
        //     (a, b) -> {
        //         int distA = Math.abs(a - x);
        //         int distB = Math.abs(b - x);
        //         if (distA == distB) return b - a; // if tie, remove larger one first
        //         return distB - distA; // max-heap by distance
        //     }
        // );

        // for (int num : arr) {
        //     heap.offer(num);
        //     if (heap.size() > k) {
        //         heap.poll();
        //     }
        // }

        // // Extract elements
        // List<Integer> result = new ArrayList<>(heap);
        // Collections.sort(result); // required: ascending order
        // return result;
    }
}