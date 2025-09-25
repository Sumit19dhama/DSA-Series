class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();

        int[][] dp = new int[m][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for(int j = 0; j < m; j++){
            dp[m-1][j] = triangle.get(m-1).get(j);
        }

        for(int i = m-2; i >= 0; i--){
            for(int j = i; j >= 0; j--){

                int below = dp[i+1][j];
                int diagonal = dp[i+1][j+1];

                dp[i][j] = triangle.get(i).get(j) + Math.min(below, diagonal);
            }
        }

        return dp[0][0];
    }
}