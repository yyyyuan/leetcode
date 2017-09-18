class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) return 0;
        int[] result = new int[amount + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[amount] = 0;
        for (int i = amount; i >= 0; i--) {
            if (result[i] == Integer.MAX_VALUE) continue;
            for (int n : coins) {
                if (i - n >= 0) result[i - n] = Math.min(result[i - n], result[i] + 1);
            }
        }
        
        return result[0] == Integer.MAX_VALUE ? -1 : result[0];
    }
}
