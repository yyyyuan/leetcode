class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] dp = new int[prices.length];
        dp[1] = Math.max(0, prices[1] - prices[0]);
        for (int i = 1; i < prices.length; i++) {
            int maxBefore = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (j < 2) dp[i] = Math.max(dp[i], prices[i] - prices[j]);
                else {
                    maxBefore = Math.max(maxBefore, dp[j - 2]);
                    dp[i] = Math.max(dp[i], prices[i] - prices[j] + maxBefore);
                } 
            }
        }
        int max = 0;
        for (int n : dp) max = Math.max(max, n);
        return max;
    }
}
