// I think this should be too much time cost, but it seems like it could pass the test.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        
        if (matrix[m][n] < target) return false;
        
        while (m > 0 && n > 0) {
            if (matrix[m - 1][n - 1] < target) break;
            else {
                for (int num : matrix[m]) if (num == target) return true;
                for (int i = 0; i <= m; i++) {
                    if (matrix[i][n] == target) return true;
                }
                m -= 1;
                n -= 1;
            }
        }
        
        for (int num : matrix[m]) if (num == target) return true;
        for (int i = 0; i <= m; i++) {
            if (matrix[i][n] == target) return true;
        }
        return false;
    }
}
