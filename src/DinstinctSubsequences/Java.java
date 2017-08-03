public class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() == 0 && t.length() == 0) return 1;
        int[][] map = new int[s.length() + 1][t.length() + 1];
        map[0][0] = 1;
        
        for (int i = 0; i < s.length(); i++) map[i][0] = 1;
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    map[i + 1][j + 1] = map[i][j] + map[i][j + 1];
                }
               else map[i + 1][j + 1] = map[i][j + 1];
            }
        }
        
        return map[s.length()][t.length()];
    }
}
