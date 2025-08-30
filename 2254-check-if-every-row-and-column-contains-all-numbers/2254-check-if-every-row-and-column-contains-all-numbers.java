class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        // Check each row
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1]; 
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                if (val < 1 || val > n || seen[val]) {
                    return false; // value out of range or duplicate
                }
                seen[val] = true;
            }
        }

        for (int j = 0; j < n; j++) {
            boolean[] seen = new boolean[n + 1]; 
            for (int i = 0; i < n; i++) {
                int val = matrix[i][j];
                if (val < 1 || val > n || seen[val]) {
                    return false;
                }
                seen[val] = true;
            }
        }

        return true;
    }
}