public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        
        int k = 2;
        int[][] map = new int[k + 1][n];
        
        for (int i = 1; i <= k; i++) {
            int temp = map[i][0] - prices[0]; 
            for (int j = 1; j < n; j++) {
                map[i][j] = Math.max(map[i][j - 1], prices[j] + temp);
                temp = Math.max(temp, map[i - 1][j] - prices[j]);
            }
        }
        
        return map[k][n - 1];
    }
}
