class NumMatrix {
    int[][] map;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        map = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) map[i][j] = matrix[0][0];
                else if (i == 0) map[0][j] = map[0][j - 1] + matrix[0][j];
                else if (j == 0) map[i][0] = map[i - 1][0] + matrix[i][0];
                else {
                    map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + matrix[i][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) return map[row2][col2];
        if (row1 == 0) return map[row2][col2] - map[row2][col1 - 1];
        if (col1 == 0) return map[row2][col2] - map[row1 - 1][col2];
        
        return map[row2][col2] - map[row1 - 1][col2] - map[row2][col1 - 1] + map[row1 -1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
