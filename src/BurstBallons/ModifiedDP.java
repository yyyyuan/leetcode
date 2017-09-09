// This is built based on my unsuccessful solutions before. It used the concept of divind and conquer, dp[i][j] means the maximal coins
// earned by bursting ballons from range [i .... j].
class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        return helper(nums, 0, nums.length - 1, dp);
    }
    
    private int helper(int[] nums, int start, int end, int[][] dp) {
        if (start > end) return 0;
        if (dp[start][end] != 0) return dp[start][end];        
        
        int result = 0;
        for (int i = start; i <= end; i++) {  // Here i means the last ballon to burst, NOT FIRST!
            int left = findAdj(nums, start - 1);
            int right = findAdj(nums, end + 1);
            
            int earned = left * nums[i] * right;
            
            int leftEarned = helper(nums, start, i - 1, dp);
            int rightEarned = helper(nums, i + 1, end, dp);            
            result = Math.max(result, earned + leftEarned + rightEarned);
                        
        }
        
        dp[start][end] = result;
        return result;
    }
    
    private int findAdj(int[] nums, int i) {
        if (i == -1 || i == nums.length) return 1;
        return nums[i];
    }
}
