public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<Character, Character>();
        Map<Character, Character> reverseMap = new HashMap<Character, Character>();
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        
        for (int i = 0; i < s1.length; i++) {
            if (!map.containsKey(s1[i])) {
                if (reverseMap.containsKey(s2[i]) && reverseMap.get(s2[i]) != s1[i]) return false;
                map.put(s1[i], s2[i]);
                reverseMap.put(s2[i], s1[i]);
            }
            else {
                if (map.get(s1[i]) != s2[i]) return false;
            }
        }
        return true;
        
    }
}
