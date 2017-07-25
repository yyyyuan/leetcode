// Here I use int[] instead of hashmap to solve the problem.
public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length()) return "";
        
        int miniStart = 0;
        int start = 0;
        int length = Integer.MAX_VALUE;
        int count = t.length();
        int[] map = new int[256];
        
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map[s.charAt(end)] > 0) count--;
            map[s.charAt(end)]--;
            
            while (count == 0) {
                if (end - start + 1 < length) {
                    length = end - start + 1;
                    miniStart = start;
                }
                
                map[s.charAt(start)]++;
                if (map[s.charAt(start)] > 0) count++;
                
                start++;
            }
        }
        
        if (length > s.length()) return "";
        return s.substring(miniStart, miniStart + length);
    }
}
