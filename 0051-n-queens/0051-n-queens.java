class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> result = new ArrayList<>();

        for(char[] row : board){
            Arrays.fill(row, '.');
        }

        backtrack(0, board, result, n);
        return result;
    }


    private void backtrack(int row, char[][] board, List<List<String>> result, int n){
        if(row == n){
            result.add(ConstructBoard(board));
            return;
        }

        for(int col = 0; col < n; col++){
            if(isSafe(board, row, col, n)){
                board[row][col] = 'Q';
                backtrack(row + 1, board, result, n);
                board[row][col] = '.';

            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n){
        for(int i = 0; i < row; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i-- ,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = row-1, j = col + 1; i >= 0 && j < n; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    private List<String> ConstructBoard(char[][] board){
        List<String> temp = new ArrayList<>();
        for(char[] ch : board){
            temp.add(new String(ch));
        }
        return temp;
    }
}