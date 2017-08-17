public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<Character, Character>();
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        
        for (int i = 0; i < s1.length; i++) {
            if (!map.containsKey(s1[i])) {
                if (map.containsValue(s2[i])) return false;
                else map.put(s1[i], s2[i]);
            }
            else {
                if (map.get(s1[i]) != s2[i]) return false;
            }
        }
        return true;
        
    }
}
