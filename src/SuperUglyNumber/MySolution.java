class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (primes.length == 0) return 1;
        int[] dp = new int[n];
//        Queue<Integer> test = new LinkedList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int prime : primes) queue.offer(prime);
        
        int[] indexes = new int[primes.length];
        dp[0] = 1;
        
        for (int i = 1; i < n; i++) {
            int number = queue.poll();
            dp[i] = number;
            for (int index = 0; index < indexes.length; index++) {
                if (number == primes[index] * dp[indexes[index]]) {
                    indexes[index]++;
                    if (!queue.contains(primes[index] * dp[indexes[index]])) queue.offer(primes[index] * dp[indexes[index]]);
                }
            }
        }
        
        return dp[n - 1];
    }
}
