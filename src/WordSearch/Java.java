public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        if (m == 0 || word.length() == 0) return false;
        boolean[][] map = new boolean[board.length][board[0].length];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (backTrack(board, word, map, i, j)) return true;
            }
        }
        
        return false;
        
    }

    public boolean backTrack(char[][] board, String word, boolean[][] map, int i, int j) {
        if (word.length() == 0) return true;
        if (i < 0 || i >= board.length || j >= board[0].length || j < 0 || board[i][j] != word.charAt(0) || map[i][j] ) return false;
        
        map[i][j] = true;
        word = word.substring(1);
        boolean f1 = false, f2 = false, f3 = false, f4 = false;
        f1 = backTrack(board, word, map, i+1, j);
        f2 = backTrack(board, word, map, i-1, j);
        f3 = backTrack(board, word, map, i, j+1);
        f4 = backTrack(board, word, map, i, j-1); 
        if (f1 || f2 || f3 || f4) return true;
        else {
            map[i][j] = false;
            return false;
        }
    }
}
