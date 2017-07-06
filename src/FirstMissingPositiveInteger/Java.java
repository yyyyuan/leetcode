public class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i<nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) swap(nums, nums[i]-1, i);
            else i++;
        }
        
        i = 0;
        while (i < nums.length) {
            if (nums[i] != i+1) return i+1;
            i++;
        }
        
        return i+1;
    }
    
    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}
