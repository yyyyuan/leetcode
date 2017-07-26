public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        int i = 0;
        int count = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
                count = 1;
            }
            else {
                if (count < 2) {
                    i++;
                    nums[i] = nums[j];
                    count++;
                }
                else count++;
            }
        }
        
        return i + 1;
    }
}
