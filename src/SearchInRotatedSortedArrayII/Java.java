public class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end)/2;
            if (nums[mid] == target) return true;

            // If we know for sure that left side is sorted or right side is unsorted.
            if (nums[start] < nums[mid] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) end = mid - 1;
                else start = mid + 1;
            }
            
            // If we know for sure that right side is sorted or left side is unsorted.
            else if (nums[end] > nums[mid] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }
            
            // If we reach here we know that nums[start] = nums[end] = nums[mid], in that case we will remove the last duplicate element in the array.
            else end--;

        }
        
        return false;
     
    }
}
