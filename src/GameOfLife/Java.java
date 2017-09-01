class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = countLives(board, m, n, i, j);
                if (board[i][j] == 0 && lives == 3) board[i][j] = 2;
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) board[i][j] = 3;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    
    private int countLives(int[][] board, int m, int n, int x, int y) {
        int count = 0;
        for (int i = Math.max(0, x - 1); i <= Math.min(x + 1, m - 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(y + 1, n - 1); j++) {
                if ((board[i][j] & 1) == 1) count++;
            }
        }
        if ((board[x][y] & 1) == 1) count--;
        return count;
    }
}
