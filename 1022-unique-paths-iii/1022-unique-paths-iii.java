class Solution {
    private int result = 0;
    private int emptyCount = 0;
    private int rows, cols;

    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int startRow = 0, startCol = 0;

        // Count empty cells and locate the start
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    emptyCount++;
                } else if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        // DFS from start
        dfs(grid, startRow, startCol, -1); // start counts as visited (-1 step already)
        return result;
    }

    private void dfs(int[][] grid, int r, int c, int steps) {
        // Out of bounds or obstacle
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == -1) return;

        // If reached the end
        if (grid[r][c] == 2) {
            if (steps == emptyCount) { // visited all empty squares
                result++;
            }
            return;
        }

        // Mark as visited
        int temp = grid[r][c];
        grid[r][c] = -1;

        // Explore 4 directions
        dfs(grid, r + 1, c, steps + 1);
        dfs(grid, r - 1, c, steps + 1);
        dfs(grid, r, c + 1, steps + 1);
        dfs(grid, r, c - 1, steps + 1);

        // Backtrack
        grid[r][c] = temp;
    }
}
