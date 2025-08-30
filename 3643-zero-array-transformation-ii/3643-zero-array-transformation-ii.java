class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int m = queries.length;

        int lo = 0, hi = m, ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (canZero(nums, queries, mid)) {
                ans = mid;
                hi = mid - 1; 
            } else {
                lo = mid + 1; 
            }
        }

        return ans;
    }
    private boolean canZero(int[] nums, int[][] queries, int k){
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            diff[l] += val;
            if (r + 1 < n) {
                diff[r + 1] -= val;
            }
        }

        long cap = 0;
        for (int i = 0; i < n; i++) {
            cap += diff[i];
            if (nums[i] > cap) {
                return false;
            }
        }

        return true;
    }
}