public class Solution {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i <= length; i++) {
            int h = (i == length ? 0 : heights[i]);
            
            while (!stack.isEmpty() && heights[stack.peek()] >= h) {
                int tp = stack.pop();
                max = Math.max(max, heights[tp] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
            }
            
            stack.push(i);
            
        }
        
        return max;
    }
}
