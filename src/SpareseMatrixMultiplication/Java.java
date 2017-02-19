public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = B.length, p = B[0].length;
        int[][] result = new int[A.length][B[0].length];
        
        for (int i=0; i<m; i++) {
            for (int k=0; k<n; k++) {
                if (A[i][k] != 0) {
                    for (int j=0; j<p; j++) {
                        if (B[k][j] != 0) result[i][j] += A[i][k]*B[k][j];
                    }
                }
            }
        }

        return result;
    }
}
