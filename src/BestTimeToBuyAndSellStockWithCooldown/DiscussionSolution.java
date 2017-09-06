class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
//        int[] buy = new int[prices.length];
//        int[] sell = new int[prices.length];
//        buy[0] = -prices[0];
        
        int b0 = 0, b1 = -prices[0];
        int s0 = 0, s1 = 0, s2 = 0;
        
        for (int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
            
//            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
//            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        
        return s0;
    }
}
