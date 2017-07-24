public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;      
        int m = matrix.length, n = matrix[0].length;
        int begin = 0, end = m * n - 1;
        
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            int mid_value = matrix[mid / n][mid % n];
            if (mid_value == target) return true;
            else if (mid_value < target) begin = mid + 1;
            else end = mid - 1;
        }
        
        return false;
    }
}
