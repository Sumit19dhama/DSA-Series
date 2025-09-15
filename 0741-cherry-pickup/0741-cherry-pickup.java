class Solution {
    private int n;
    private int[][] grid;
    private Integer[][][] memo;
    
    public int cherryPickup(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        this.memo = new Integer[n][n][n]; 

        int result = Math.max(0, dfs(0, 0, 0));
        return result;
    }
    private int dfs(int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2; // steps = r1+c1 = r2+c2

        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n) return Integer.MIN_VALUE;

        if (grid[r1][c1] == -1 || grid[r2][c2] == -1) return Integer.MIN_VALUE;

        if (r1 == n - 1 && c1 == n - 1) return grid[r1][c1];

        if (memo[r1][c1][r2] != null) return memo[r1][c1][r2];

        int cherries = grid[r1][c1];
        if (r1 != r2 || c1 != c2) {
            cherries += grid[r2][c2]; 
        }

        int best = Math.max(
            Math.max(dfs(r1 + 1, c1, r2 + 1), dfs(r1 + 1, c1, r2)),
            Math.max(dfs(r1, c1 + 1, r2 + 1), dfs(r1, c1 + 1, r2))
        );

        cherries += best;
        memo[r1][c1][r2] = cherries;
        return cherries;
    }

}