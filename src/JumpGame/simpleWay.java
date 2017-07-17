public class Solution {
    public boolean canJump(int[] nums) {
        
        int currFarthest = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > currFarthest) return false;
            currFarthest = Math.max(currFarthest, i + nums[i]);
        }
        
        return true;
        
        
    }
}
