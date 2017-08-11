public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] maximum = new int[nums.length];
        int largestPositive = 0;
        int smallestNegative = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                largestPositive = Math.max(nums[i], largestPositive * nums[i]);
                smallestNegative = Math.min(smallestNegative * nums[i], nums[i]);
                maximum[i] = largestPositive;
            }
            else if (nums[i] < 0) {
                int temp = largestPositive;     // It needs to store this value cause largestPositive will change in next line.
                largestPositive = Math.max(nums[i], smallestNegative * nums[i]);
                smallestNegative = Math.min(nums[i], temp * nums[i]);
                maximum[i] = largestPositive;
            }
            else {
                largestPositive = 0;
                smallestNegative = 0;
                maximum[i] = 0;
            }
        }
        
        int max = 0;
        for (int n : maximum) max = Math.max(max, n);
        return max;
    }
}
