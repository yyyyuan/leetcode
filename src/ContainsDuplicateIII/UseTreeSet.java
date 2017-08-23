class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> values = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = values.floor((long)nums[i] + t);
            Long ceil = values.ceiling((long)nums[i] - t);
            if ((floor != null && floor >= (long)nums[i])
               || (ceil != null && ceil <= (long)nums[i])) return true;
            
            values.add((long)nums[i]);
            if (i >= k) values.remove((long)(nums[i - k]));
        }
        return false;
    }
}
