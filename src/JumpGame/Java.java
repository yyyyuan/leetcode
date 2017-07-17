public class Solution {
    public boolean canJump(int[] nums) {
        
        int currEnd = 0, currFarthest = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if (i == currEnd) currEnd = currFarthest;
        }
        
        return currEnd >= nums.length - 1;    // Here I detect if the we can go to the last index in the array, using currEnd to detect.
    }
}
