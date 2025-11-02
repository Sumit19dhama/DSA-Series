class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        // 0 = empty, 1 = guard, 2 = wall, 3 = guarded

        for (int[] g : guards) grid[g[0]][g[1]] = 1;
        for (int[] w : walls) grid[w[0]][w[1]] = 2;

        // Directions: up, down, left, right
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int[] g : guards) {
            for (int[] d : dirs) {
                int r = g[0] + d[0];
                int c = g[1] + d[1];
                while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] != 1 && grid[r][c] != 2) {
                    if (grid[r][c] == 0) grid[r][c] = 3; // Mark as guarded
                    r += d[0];
                    c += d[1];
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count++;
            }
        }

        return count;
    }
}