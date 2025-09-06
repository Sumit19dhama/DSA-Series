class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        
        // Step 1: Binary search to find insertion position by start
        int left = 0, right = n - 1, pos = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][0] >= newInterval[0]) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Step 2: Add all intervals before pos (non-overlapping and left side)
        int i = 0;
        while (i < pos && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 3: Merge with overlapping intervals starting from i
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Step 4: Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}