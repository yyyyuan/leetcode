public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
                
        int[][] count = new int[m][n];
        
        // This handles corner cases.
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) count[i][0] = 1;
            else break;
        }
        
        // This handles corner cases too.
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] != 1) count[0][j] = 1;
            else break;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) count[i][j] = 0;
                else count[i][j] = count[i - 1][j] + count[i][j - 1];
            }
        }
        
        return count[m - 1][n - 1];    
    }
}
