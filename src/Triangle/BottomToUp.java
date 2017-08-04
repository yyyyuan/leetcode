public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] map = new int[n];
        List<Integer> row = triangle.get(n - 1);
        for (int i = 0; i < n; i++) {
            map[i] = row.get(i);
        }
        
        for (int layer = n - 2; layer >= 0; layer--) {
            row = triangle.get(layer);
            for (int i = 0; i <= layer; i++) {
                map[i] = Math.min(map[i], map[i + 1]) + row.get(i);
            }
        }
        
        return map[0];
    }
}
