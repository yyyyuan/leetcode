public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            check(board, i, 0, m, n);
            if (n > 1)
                check(board, i, n - 1, m, n);
        }
        
        for (int j = 1; j + 1 < n; j++) {
            check(board, 0, j, m, n);
            if (m > 1)
                check(board, m - 1, j, m, n);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'K') board[i][j] = 'O';
            }
        }
    }
    
    private void check(char[][] board, int i, int j, int rows, int cols) {
        if (board[i][j] == 'O') {
            board[i][j] = 'K';
            if (i - 1 > 0) check(board, i - 1, j, rows, cols);
            if (j - 1 > 0) check(board, i, j - 1, rows, cols);
            if (i + 1 < rows) check(board, i + 1, j, rows, cols);
            if (j + 1 < cols) check(board, i, j + 1, rows, cols);
        }
    }
}
