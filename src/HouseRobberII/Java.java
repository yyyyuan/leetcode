class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    private int rob (int[] nums, int start, int end) {
        int include = 0, exclude = 0;
        for (int i = start; i <= end; i++) {
            int temp = exclude;
            exclude = Math.max(exclude, include);
            include = temp + nums[i];
        }
        return Math.max(include, exclude);
    }
}
