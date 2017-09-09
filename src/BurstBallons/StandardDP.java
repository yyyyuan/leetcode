// This will take O(N^3) to finish.
class Solution {
    public int maxCoins(int[] nums) {
        if (nums.length == 0) return 0;
        int[][] dp = new int[nums.length][nums.length];
        
        for (int len = 1; len <= nums.length; len++) {
            for (int start = 0; start <= nums.length - len; start++) {
                int end = start + len - 1;
                for (int i = start; i <= end; i++) {
                    int left = findAdj(nums, start - 1);
                    int right = findAdj(nums, end + 1);
                    int earned = left * nums[i] * right;
                    
                    earned += i == start ? 0 : dp[start][i - 1];
                    earned += i == end ? 0 : dp[i + 1][end];
                    dp[start][end] = Math.max(dp[start][end], earned);
                }
            }
        }
                
        return dp[0][nums.length - 1];
    }
    
    private int findAdj(int[] nums, int i) {
        if (i == -1 || i == nums.length) return 1;
        return nums[i];
    }
}
