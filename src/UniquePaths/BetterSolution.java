public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        
        int[][] count = new int[m][n];
        
        // This handles corner cases.
        for (int i = 0; i < m; i++) {
            count[i][0] = 1;  
        }
        
        // This handles corner cases too.
        for (int j = 0; j < n; j++) {
            count[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                count[i][j] = count[i - 1][j] + count[i][j - 1];
            }
        }
        
        return count[m - 1][n - 1];
    }
}
