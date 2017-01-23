public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxValue, temp;
        
        if (height[right] > height[left]) maxValue = (right - left) * height[left];
        else maxValue = (right - left) * height[right];
        
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left+1] > height[left]) {
                    int width = (right - left - 1);
                    if (height[right] > height[left+1] && left + 1 != right) {
                        temp = width * height[left+1];
                    } else {
                        temp = width * height[right];
                    }
                    
                    if (temp > maxValue) maxValue = temp;
                    left++;
                }
                else {
                    left++;
                }
            } 
            else {
                if (height[right-1] > height[right]) {
                    int width = (right - 1 - left);
                    if (height[left] > height[right-1] && right - 1 != left) {
                        temp = width * height[right-1];
                    } else {
                        temp = width * height[left];
                    }
                    
                    if (temp > maxValue) maxValue = temp;
                    right--;
                }
                else {
                    right--;
                }
            }
        }
        
        return maxValue;
        
    }
}
