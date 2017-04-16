public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || words == null || words.length == 0) return result;

        int length = words[0].length();
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String w : words) map.put(w, map.containsKey(w) ? map.get(w)+1 : 1);
        
        for (int i=0; i <= s.length() - length * words.length; ++i) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j=0; j<words.length; ++j) {
                String str = s.substring(i + j * length, i + j * length + length);
                if (copy.containsKey(str)) {
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                }
                else break;
            }
            if (copy.isEmpty()) {
                result.add(i);
            }
        }
        
        return result;
    }
}
