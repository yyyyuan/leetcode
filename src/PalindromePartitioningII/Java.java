public class Solution {
    public int minCut(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        boolean[][] pal = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
//            dp[i] = i;
            for (int j = 0; j <= i; j++) {
                if (chs[i] == chs[j] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    dp[i] = j == 0 ? 0 : Math.min(dp[i], dp[j - 1] + 1);
                }
            }
//            dp[i] = min;
        }
        
        return dp[n - 1];
    }
}
