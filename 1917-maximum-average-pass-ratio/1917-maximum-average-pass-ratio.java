class Solution {

    private double gain(int pass, int total) {
        return (double)(pass + 1) / (total + 1) - (double)pass / total;
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(gain(b[0], b[1]), gain(a[0], a[1]))
        );

        for (int[] c : classes) {
            pq.offer(new int[]{c[0], c[1]});
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] c = pq.poll();
            c[0]++; 
            c[1]++; 
            pq.offer(c);
        }

        double totalRatio = 0.0;
        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            totalRatio += (double)c[0] / c[1];
        }

        return totalRatio / classes.length;
    }
}