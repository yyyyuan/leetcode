class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) return result;
        int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
        
            // Here I simulate the codes in the blog: https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
            if (count1 == 0 && nums[i] != number2) number1 = nums[i];
            else if (count2 == 0) number2 = nums[i];
            
            if (number1 == nums[i]) count1++;
            else if (number2 == nums[i]) count2++;
            else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (n == number1) count1++;
            else if (n == number2) count2++;
        }
        
        if (count1 > (len / 3)) result.add(number1);
        if (count2 > (len / 3)) result.add(number2);
        return result;      
    }
}
