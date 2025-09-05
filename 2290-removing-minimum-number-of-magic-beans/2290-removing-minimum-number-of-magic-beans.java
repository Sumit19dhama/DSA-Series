class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;

        long totalSum = 0;
        for(int value : beans){
            totalSum += value;
        }

        long minRemoval = Long.MAX_VALUE;
        for(int i = 0; i < n; i++){
            long kept = (long)beans[i] * (n - i);
            long removal = totalSum - kept;
            minRemoval = Math.min(removal, minRemoval);
        }

        return minRemoval;
    }
}