// This seems to be more fast, but it doesn't show too much difference in the time test.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        
        int m = 0;
        int n = matrix[0].length - 1;
        
        
        while (m < matrix.length && n >= 0) {
            if (matrix[m][n] == target) return true;
            else if (matrix[m][n] > target) n--;
            else m++;
        }
        return false;
    }
}
