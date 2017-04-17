public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (p.length() > s.length()) return result;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i=0; i<p.length(); ++i) {
            char a = p.charAt(i);
            if (map.containsKey(a)) map.put(a, map.get(a)+1);
            else map.put(a, 1);
        }
        
        int count = p.length();
        int start = 0, end = 0;
//        int length = Integer.MAX_VALUE;
        
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if (map.get(c) >= 0) count--;
            }
            end++;
            
            while (count == 0) {
                char temp = s.charAt(start);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp)+1);
                    if (map.get(temp) > 0) count++;
                }
                
                if (end - start == p.length()) {
                    result.add(start);
                }
                start++;
            }
        }
        
        return result;
    }
}
