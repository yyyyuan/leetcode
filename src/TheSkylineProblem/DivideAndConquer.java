class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        return merge(buildings, 0, buildings.length - 1);
    }
    
    private LinkedList<int[]> merge(int[][] buildings, int lo, int hi) {
        LinkedList<int[]> result = new LinkedList<>();
        if (lo > hi) return result;
        if (lo == hi) {
            result.add(new int[]{buildings[lo][0], buildings[lo][2]});
            result.add(new int[]{buildings[lo][1], 0});
            return result;
        }
        
        int mid = lo + (hi - lo) / 2;
        LinkedList<int[]> left = merge(buildings, lo, mid);
        LinkedList<int[]> right = merge(buildings, mid + 1, hi);
        
        int leftH = 0, rightH = 0;
        while (!left.isEmpty() || !right.isEmpty()) {
            long x1 = left.isEmpty() ? Long.MAX_VALUE : left.peekFirst()[0];
            long x2 = right.isEmpty() ? Long.MAX_VALUE : right.peekFirst()[0];
            int x = 0;
            if (x1 < x2) {
                int[] temp = left.pollFirst();
                x = temp[0];
                leftH = temp[1];
            }
            else if (x1 > x2) {
                int[] temp = right.pollFirst();
                x = temp[0];
                rightH = temp[1];
            }
            else {
                x = left.peekFirst()[0];
                leftH = left.pollFirst()[1];
                rightH = right.pollFirst()[1];
            }
            
            int h = Math.max(leftH, rightH);
            if (result.isEmpty() || h != result.peekLast()[1]) {
                result.add(new int[]{x, h});
            }
        }
        return result;
    }
}
