// This solution can solve the problem in Olog(N).
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int size = 0;
        
        for (int n : nums) {
            int i = 0, j = size;
            while (i < j) {
                int m = (i + j) / 2;
                if (dp[m] < n) i = m + 1;
                else j = m;
            } 
            dp[i] = n;
            size = Math.max(size, i + 1);
        }

        return size;
    }
}
