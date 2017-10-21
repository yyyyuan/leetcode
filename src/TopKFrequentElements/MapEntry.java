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
        
        
        // Here I use a PriorityQueue to store a Map.Entry<Integer, Integer>, and the logic of this solution is quite straightforward.
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }

        while (result.size() < k) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            result.add(entry.getKey());
        }
        
        return result;
    }
}
