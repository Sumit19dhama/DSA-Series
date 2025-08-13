class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0; // Total net gas over all stations
        int currTank = 0;  // Current segment gas
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            int net = gas[i] - cost[i];
            totalTank += net;
            currTank += net;

            // If we run out of gas in the current segment
            if (currTank < 0) {
                // Can't start from any of the stations so far
                startIndex = i + 1;
                currTank = 0;
            }
        }

        return totalTank >= 0 ? startIndex : -1;
    }
}