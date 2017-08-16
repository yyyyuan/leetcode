public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] money = new int[nums.length + 1];
        money[1] = nums[0];
        money[2] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int maxEarned = Math.max(money[i - 2], money[i - 1]);
            money[i + 1] = maxEarned + nums[i];
        }
        return Math.max(money[nums.length], money[nums.length - 1]);
    }
}
