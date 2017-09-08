// In that solution I use a function to find the minimum value instead of using a PriorityQueue, and it's much faster.
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (primes.length == 0) return 1;
        int[] dp = new int[n];
        
        int[] indexes = new int[primes.length];
        dp[0] = 1;
        
        for (int i = 1; i < n; i++) {
            int min = findMin(indexes, primes, dp);
            dp[i] = min;
            for (int index = 0; index < indexes.length; index++) {
                if (min == primes[index] * dp[indexes[index]]) indexes[index]++;
            }
        }
        
        return dp[n - 1];
    }
    
    private int findMin(int[] indexes, int[] primes, int[] dp) {
        int min = Integer.MAX_VALUE;
        for (int index = 0; index < indexes.length; index++) {
            min = Math.min(min, primes[index] * dp[indexes[index]]);
        }
        return min;
    }
}
