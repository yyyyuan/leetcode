public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) end = mid;
            else start = mid+1;
        }
        
        return start;
    }
}
