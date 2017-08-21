// Build an array to perform the same utility as HashSet
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int n : nums) if (n < min) min = n;
        
        int max = Integer.MIN_VALUE;
        for (int n : nums) if (n > max) max = n;
        
        int[] temp = new int[max - min + 1];
        
        for (int i = 0; i < nums.length; i++) {
            if (temp[nums[i] - min] != 0) return true;
            temp[nums[i] - min] = 1;
        }
        return false;
    }
}
