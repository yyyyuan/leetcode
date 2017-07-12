public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs.length == 0) return result;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
//        Arrays.sort(strs);
        
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}
