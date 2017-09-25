class Solution {
        
    public int minPatches(int[] nums, int n) {
        int sum = 0;
        int count = 0;
        int number = 0;
        
        int index = 0;
        int value = 0;
              
        while (sum >= 0 && sum < n) {
            if (index < nums.length) {
                value = nums[index];                
            }            
            if (index == nums.length || sum < value - 1) {
                number = sum + 1;
                sum += number;
                count++;                
            }
            else {
                sum += value;
                index++;
            }
        }
        
        return count;
    }
}
