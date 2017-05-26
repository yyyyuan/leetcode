public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = firstGreaterEqual(nums, target);
        if (start == nums.length || nums[start] != target) return new int[]{-1, -1};
        
        return new int[]{start, firstGreaterEqual(nums, target + 1) - 1};
    }
    
    private int firstGreaterEqual(int[] A, int target) {
        int start = 0, end = A.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            // start <= mid < end
            if (A[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
}
