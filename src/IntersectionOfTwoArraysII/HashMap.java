class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums1) {
            if (!map.containsKey(n)) {
                map.put(n, 0);
            }
            map.put(n, map.get(n) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            if (map.containsKey(n)) {
                if (map.get(n) > 0) {
                    list.add(n);
                    map.put(n, map.get(n) - 1);
                }
            }
        }
        
        int[] result = new int[list.size()];
        int index = 0;
        
        for (int n : list) {
            result[index++] = n;
        }
        
        return result;        
    }
}
