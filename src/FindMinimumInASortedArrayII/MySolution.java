public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            if (nums[start] < nums[end]) return nums[start];
            int mid = start + (end - start) / 2;
            if (nums[start] == nums[end]) {
                if (nums[start] < nums[mid]) start = mid + 1;
                else if (nums[start] > nums[mid]) end = mid;
                else end--;
            }
            else {
                if (nums[start] <= nums[mid]) start = mid + 1;
                else end = mid;
            }
        }
        return nums[start];
    }
}
