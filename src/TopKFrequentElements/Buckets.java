class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums) {
            if (!map.containsKey(n)) {
                map.put(n, 0);
            }
            map.put(n, map.get(n) + 1);
        }
        
        // Use bucket to store all numbers within different frequencies.
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int n : map.keySet()) {
            int freq = map.get(n);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(n);
        }
        
        for (int i = bucket.length - 1; i > 0 && k > 0; i--) {
            if (bucket[i] != null) {
                List<Integer> list = bucket[i];
                result.addAll(list);
                k -= list.size();
            }
        }

        
        return result;
    }
}
