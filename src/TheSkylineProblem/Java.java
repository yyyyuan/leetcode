public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        List<int[]> height = new ArrayList<int[]>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        
        height.sort(new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                if (i1[0] != i2[0]) return i1[0] - i2[0];
                return i1[1] - i2[1];
            }
        });
        
        Queue<Integer> queue = new PriorityQueue<Integer>((a,b) -> (b-a));
        
        queue.offer(0);
        
        int prev = 0;
        
        for (int[] h : height) {
            if (h[1] < 0) {
                queue.offer(-h[1]);
            }
            else queue.remove(h[1]);
            
            int cur = queue.peek();
            
            if (prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        
        
        return result;
        
    }
}
