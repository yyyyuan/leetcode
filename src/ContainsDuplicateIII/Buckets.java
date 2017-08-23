// I may use long instead of int to pass some extreme cases using Integer.MAX_VALUE or Integer.MIN_VALUE

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        int w = t + 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) map.remove(getID(nums[i - k - 1], w));
            int m = getID(nums[i], w);
            if (map.containsKey(m)) return true;
            if (map.containsKey(m - 1) && Math.abs(nums[i] - map.get(m - 1)) < w) return true;
            if (map.containsKey(m + 1) && Math.abs(nums[i] - map.get(m + 1)) < w) return true;
            map.put(m, nums[i]);
        }
        return false;
    }
    
    private int getID(int i, int w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }
}
