public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int index = nums.length - k - 1;        
        reverse(nums, 0, index);
        reverse(nums, index + 1, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        if (start < 0) return;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
