public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int returnValue = 0;
        int compareValue = Integer.MAX_VALUE;
        Arrays.sort(nums);
        
        for (int i=0; i+2<nums.length; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int lo = i + 1, hi = nums.length - 1, sum = target - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        returnValue = target;
                        return returnValue;
                    }
                    else if ((nums[lo] + nums[hi]) < sum) {
                        if (sum - (nums[lo] + nums[hi]) < compareValue) {
                            compareValue = sum - (nums[lo] + nums[hi]);
                            returnValue = nums[i] + nums[lo] + nums[hi];
                        }
                        lo++;
                    }
                    else {
                        if ((nums[lo] + nums[hi] - sum) < compareValue) {
                            compareValue = (nums[lo] + nums[hi]) - sum;
                            returnValue = nums[i] + nums[lo] + nums[hi];

                        }
                        hi--;
                    }
              }
            }
        }
        
        return returnValue;
    }
}
