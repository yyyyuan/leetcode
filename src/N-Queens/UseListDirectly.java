public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        helper(0, new boolean[n], new boolean[2 * n], new boolean[2 * n], new ArrayList<>(), n, result);
        
        return result;
    }
    
    private void helper(int r, boolean[] cols, boolean[] d1, boolean[] d2, List<String> board, int length, List<List<String>> result) {
        if (r == length) {
            result.add(new ArrayList<>(board));
            return;
        }
        else {
            for (int c = 0; c < length; c++) {
                int id1 = r - c + length, id2 = r + c;
                if (!cols[c] && !d1[id1] && !d2[id2]) {
                    char[] row = new char[length];
                    Arrays.fill(row, '.');
                    row[c] = 'Q';
//                    board[r] = new String(row);         // Convert char array to String
                    board.add(new String(row));
                    cols[c] = true;
                    d1[id1] = true;
                    d2[id2] = true;
                    helper(r + 1, cols, d1, d2, board, length, result);
                    board.remove(board.size() - 1);
                    cols[c] = false;
                    d1[id1] = false;
                    d2[id2] = false;  
                }
            }
        }
    }
}
