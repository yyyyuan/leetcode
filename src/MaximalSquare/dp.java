class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (matrix[0][j] == '1') dp[0][j] = 1;
                }
                else if (j == 0) {
                    if (matrix[i][0] == '1') dp[i][0] = 1;
                }
                else {
                    if (matrix[i][j] == '1') {
                        int width = dp[i - 1][j - 1];
                        int min = 0;
                        int k;
                        for (k = 0; k <= width; k++) {
                            if (matrix[i - k][j] == '0') break;
                        }
                        min = k;
                        
                        for (k = 0; k <= width; k++) {
                            if (matrix[i][j - k] == '0') break;
                        }
                        
                        min = Math.min(min, k);
                        dp[i][j] = min;
                    }
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max * max;
    }
}
