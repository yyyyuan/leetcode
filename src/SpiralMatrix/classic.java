public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return result;
//        if (matrix[0].length == 0) return result;

        int m = matrix.length, n = matrix[0].length;
        int u = 0, d = m - 1, l = 0, r = n - 1;
        while (true) {
            // on the up side
            for (int col = l; col <= r; col++) result.add(matrix[u][col]);
            if (++u > d) break;
                        // right
            for (int row = u; row <= d; row++) result.add(matrix[row][r]);
            if (--r < l) break;
            // down
            for (int col = r; col >= l; col--) result.add(matrix[d][col]);
            if (--d < u) break;
            // left
            for (int row = d; row >= u; row--) result.add(matrix[row][l]);
            if (++l > r) break;
        }
        
        return result;
    }
}
