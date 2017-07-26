public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word.length() == 0) return false;
        int m = board.length, n = board[0].length;    
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(board, word, 0, i, j)) return true;
            }
        }
        
        return false;
    }
    
    private boolean check(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) return false;
        else {
            board[i][j] ^= 256;   // Use XOR operation ^= to remeber the character we have used.
            boolean exist = (check(board, word, index + 1, i + 1, j) || check(board, word, index + 1, i, j + 1)
                             || check(board, word, index + 1, i, j - 1) || check(board, word, index + 1, i - 1, j));
            board[i][j] ^= 256;   // After the check we move the character back.
            
            return exist;
        }
    }
}
