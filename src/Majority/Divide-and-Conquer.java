public class Solution {
    public int majorityElement(int[] nums) {
        return majority(nums, 0, nums.length - 1);
    }
    
    private int majority(int[] nums, int start, int end) { 
        if (start == end) return nums[start];
                
        int mid = start + (end - start) / 2;
        int a = majority(nums, start, mid);
        int b = majority(nums, mid + 1, end);
        
        if (a == b) return a;
        
        // Find the majority element from a and b.
        int countA = 0;
        int countB = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == a) countA++;
            if (nums[i] == b) countB++;
        }
        
        return (countA > countB) ? a : b;
    }
}
