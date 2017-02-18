// Trying to add some comments and get familiar with the pull request.

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0, sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k) max = i + 1;
            else if (map.containsKey(sum-k)) max = Math.max(max,i-map.get(sum-k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
}
