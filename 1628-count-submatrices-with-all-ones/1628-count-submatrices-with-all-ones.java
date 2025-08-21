class Solution {
    public int numSubmat(int[][] mat) {
      int m = mat.length, n = mat[0].length;
        int[] heights = new int[n];
        int total = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            total += countSubmatrices(heights);
        }
        return total;
    }

    private int countSubmatrices(int[] heights) {
        int n = heights.length;
        int[] sum = new int[n];
        int res = 0;
       Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                int prev = stack.peek();
                sum[i] = sum[prev] + heights[i] * (i - prev);
            } else {
                sum[i] = heights[i] * (i + 1);
            }

            res += sum[i];
            stack.push(i);
        }
        return res;
    }
}