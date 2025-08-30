class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] pos = new int[m * n + 1][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pos[mat[i][j]][0] = i; 
                pos[mat[i][j]][1] = j; 
            }
        }

        int[] rowPaint = new int[m];
        int[] colPaint = new int[n];

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int r = pos[val][0];
            int c = pos[val][1];

            rowPaint[r]++;
            colPaint[c]++;

            if (rowPaint[r] == n || colPaint[c] == m) {
                return i;
            }
        }

        return -1;
    }
}