public class Solution {
    public int minDistance(String word1, String word2) {
        
        int m = word1.length(), n = word2.length();
        if (m == 0) return n;
        if (n == 0) return m;
        int count = 0;
        int[][] map = new int[m+1][n+1];
        map[0][0] = 0;
        
        for (int i = 1; i <= m; i++) {
            map[i][0] = map[i - 1][0] + 1;
        }
        
        for (int j = 1; j <= n; j++) {
            map[0][j] = map[0][j - 1] + 1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    map[i][j] = Math.min(Math.min(map[i - 1][j - 1] + 1, map[i -1][j] + 1), map[i][j - 1] + 1);
                }
                else map[i][j] = map[i - 1][j - 1];
            }
        }
        
        return map[m][n];
    }
}
