class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            int root = 1;
            while (root * root <= i) {
                dp[i] = Math.min(dp[i], 1 + dp[i - root * root]);
                root++;
            }
        }
        return dp[n];
    }
}
