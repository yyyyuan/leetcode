public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0) return "";
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int miniStart = 0;
        int length = Integer.MAX_VALUE;
        int count = t.length();
        
        for (int i=0; i<t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i))+1);
            }
            else map.put(t.charAt(i), 1);
        }
        
        for (int j=0; j<s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j))-1);
                if (map.get(s.charAt(j)) >= 0) count--;
            }
            
            while (count == 0) {
                if (j-start+1 < length) {
                    miniStart = start;
                    length = j-start+1;
                }
                if (map.containsKey(s.charAt(start))) {
                    map.put(s.charAt(start), map.get(s.charAt(start))+1);
                    if (map.get(s.charAt(start)) > 0) count++;
                }
                start++;
            }
            
        }
        
        if(length>s.length()) return "";
        
        return s.substring(miniStart, miniStart+length);
    }
}
