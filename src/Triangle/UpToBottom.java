public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;
        int[] map = new int[n];
        Arrays.fill(map, Integer.MAX_VALUE);
        
        map[0] = triangle.get(0).get(0);
        int max = Integer.MAX_VALUE;
                
        for (int i = 1; i < n; i++) {
            List<Integer> row = triangle.get(i);
            for (int j = i - 1; j >= 0; j--) {
                map[j + 1] = Math.min(map[j + 1], map[j] + row.get(j + 1));
                map[j] = map[j] + row.get(j); 
            }

        }
        
        for (int i = 0; i < n; i++) {
            max = Math.min(max, map[i]);
        }
        
        return max;
    }
    
}
