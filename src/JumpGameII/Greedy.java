public class Solution {
    public int jump(int[] nums) {
        int jumps = 0, currEnd = 0, currFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if (i == currEnd) {
                jumps++;
                currEnd = currFarthest;
            }
        }
        
        if (currEnd < nums.length - 1) return Integer.MAX_VALUE;    // This could handle the case where it can't jump to the last index.

        
        return jumps;
    }
}
