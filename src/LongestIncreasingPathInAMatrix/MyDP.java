class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int count = 0;
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int path = longestPath(matrix, dp, i, j);
 //               dp[i][j] = path;
                count = Math.max(count, path);
            }
        }
        
        return count;
    }
    
    private int longestPath(int[][] matrix, int[][] dp, int i, int j) {
//        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return 0;
        if (dp[i][j] != 0) return dp[i][j];         // This is using the idea of cache.
        
        int length = 1;
                
        int value = matrix[i][j];
        int candidate = 0;
        if (i < matrix.length - 1 && value < matrix[i + 1][j]) {
            if (dp[i + 1][j] != 0) {
                candidate = Math.max(candidate, dp[i + 1][j]);
            }
            else
                candidate = Math.max(candidate, longestPath(matrix, dp, i + 1, j));
        }
        if (i > 0 && value < matrix[i - 1][j]) {
            if (dp[i - 1][j] != 0) {
                candidate = Math.max(candidate, dp[i - 1][j]);                
            }
            else
                candidate = Math.max(candidate, longestPath(matrix, dp, i - 1, j));
        }
        if (j < matrix[0].length - 1 && value < matrix[i][j + 1]) {
            if (dp[i][j + 1] != 0) {
                candidate = Math.max(candidate, dp[i][j + 1]);
            }
            else
                candidate = Math.max(candidate, longestPath(matrix, dp, i, j + 1));
        }
        if (j > 0 && value < matrix[i][j - 1]) {
            if (dp[i][j - 1] != 0) {
                candidate = Math.max(candidate, dp[i][j - 1]);
            }
            else 
                candidate = Math.max(candidate, longestPath(matrix, dp, i, j - 1));
        }
        
        dp[i][j] = 1 + candidate;
        
        return 1 + candidate;
    }
}
