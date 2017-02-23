public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minStart = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minStart) minStart = prices[i];
            maxProfit = Math.max(maxProfit, prices[i]-minStart);
        }
        
        return maxProfit;
    }
}
