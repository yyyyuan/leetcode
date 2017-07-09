public class Solution {
    public int trap(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (maxLeft >= height[left]) result += maxLeft - height[left];
                else maxLeft = height[left];
                left++;
            }
            else {
                if (maxRight >= height[right]) result += maxRight - height[right];
                else maxRight = height[right];
                right--;
            }
        }
        
        return result;
    }
}
