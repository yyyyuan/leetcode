// This question is solved using same method as Spiral Matrix.
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        int index = 1;
        
        int u = 0, d = n - 1, l = 0, r = n - 1;
        while (true) {
            for (int col = l; col <= r; col++) result[u][col] = index++;
            if (++u > d) break;     // Here it's faster.
            
            for (int row = u; row <= d; row++) result[row][r] = index++;
            if (--r < l) break;
            
            for (int col = r; col >= l; col--) result[d][col] = index++;
            if (--d < u) break;
            
            for (int row = d; row >= u; row--) result[row][l] = index++;
            if (++l > r) break;
        }
        
        return result;
    }
}
