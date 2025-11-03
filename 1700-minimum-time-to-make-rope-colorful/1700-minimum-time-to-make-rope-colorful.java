class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        int n = colors.length();
        
        for (int i = 1; i < n; i++) {
            // If current and previous balloons have the same color
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // Add the smaller time to total (remove that balloon)
                totalTime += Math.min(neededTime[i], neededTime[i - 1]);
                
                // Keep the balloon with larger neededTime
                // so update neededTime[i] to reflect that
                if (neededTime[i - 1] > neededTime[i]) {
                    neededTime[i] = neededTime[i - 1];
                }
            }
        }
        
        return totalTime;
    }
}