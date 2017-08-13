public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        
        int n = Math.min(s1.length, s2.length);
        
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(s1[i]), b = Integer.parseInt(s2[i]);
            if (a < b) return -1;
            if (a > b) return 1;
        }
        
        if (s1.length < s2.length) {
            for (int i = n; i < s2.length; i++) if (Integer.parseInt(s2[i]) != 0) return -1;
        }
        else if (s1.length > s2.length) {
            for (int i = n; i < s1.length; i++) if (Integer.parseInt(s1[i]) != 0) return 1;
        }
        
        return 0;
    }
}
