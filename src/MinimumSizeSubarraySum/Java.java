public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int sum = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (sum >= s) {
                while (sum - nums[start] >= s) {
                    sum -= nums[start];
                    start++;
                }
                len = Math.min(len, i-start+1);
            }
        }
        
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
