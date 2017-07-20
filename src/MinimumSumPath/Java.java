public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        
        int m = grid.length, n = grid[0].length;
        int[][] count = new int[m][n];
        count[0][0] = grid[0][0];
        
        for (int i = 1; i < m; i++) {
            count[i][0] = count[i - 1][0] + grid[i][0];
        }
        
        for (int j = 1; j < n; j++) {
            count[0][j] = count[0][j - 1] + grid[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                count[i][j] = grid[i][j] + Math.min(count[i - 1][j], count[i][j - 1]);
            }
        }
        
        return count[m - 1][n - 1];
    }
}
