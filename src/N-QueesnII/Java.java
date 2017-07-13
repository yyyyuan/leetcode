public class Solution {
    int result = 0;         // Here I set the variable out of the functions because it can't be modified like lists, so this is a static variable to use.
    public int totalNQueens(int n) {
        helper(0, new boolean[n], new boolean[2 * n], new boolean[2 * n], new String[n]);
        
        return result;
    }
    
    private void helper(int r, boolean[] cols, boolean[] d1, boolean[] d2, String[] board) {
        if (r == board.length) result++;
        else {
            for (int c = 0; c < board.length; c++) {
                int id1 = r - c + board.length, id2 = r + c;
                if (!cols[c] && !d1[id1] && !d2[id2]) {
                    char[] row = new char[board.length];
                    Arrays.fill(row, '.');
                    row[c] = 'Q';
                    board[r] = new String(row);
                    cols[c] = true;
                    d1[id1] = true;
                    d2[id2] = true;
                    helper(r + 1, cols, d1, d2, board);
                    cols[c] = false;
                    d1[id1] = false;
                    d2[id2] = false;
                }
            }
        }
    }
}
