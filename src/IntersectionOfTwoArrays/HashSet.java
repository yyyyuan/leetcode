class Solution {
    // The trick part is how to generate the final result array.
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        
        for (int n : nums1) {
            if (!set.contains(n)) set.add(n);
        }
        
        Set<Integer> dump = new HashSet<>();
        for (int n : nums2) {
            if (set.contains(n) && !dump.contains(n)) {
                dump.add(n);
            }
        }
        
        int[] result = new int[dump.size()];
        int index = 0;
        
        for (Integer n : dump) {
            result[index++] = n;
        }
        
        return result;
    }
}
