public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return result;
//        if (matrix[0].length == 0) return result;
        
        int nr = matrix.length;
        int nc = matrix[0].length;
        
        int[] nSteps = new int[] {nc, nr - 1};
        int iDir = 0;
        int ir = 0, ic = -1;
        while (nSteps[iDir%2] != 0) {
            for (int i =0; i < nSteps[iDir%2]; i++) {
                ir += dirs[iDir][0];
                ic += dirs[iDir][1];
                result.add(matrix[ir][ic]);
            }
            nSteps[iDir%2]--;
            iDir = (iDir + 1) % 4;
        }
        
        return result;
    }
}
