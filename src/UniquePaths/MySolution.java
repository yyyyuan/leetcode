// This is not the fastest, because there are many corner cases which can be easily handled.
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        
        int[][] count = new int[m][n];
        
        count[0][0] = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0 ) count[i][j] = count[i][j - 1] + count[i - 1][j];
                else if (i == 0 && j > 0) count[i][j] = count[i][j - 1];
                else if (j == 0 && i > 0) count[i][j] = count[i - 1][j];
            }
        }
        
        return count[m - 1][n - 1];
    }
}
