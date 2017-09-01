class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        char[] chs = pattern.toCharArray();
        if (chs.length != strs.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < chs.length; i++) {
            if (map.containsKey(chs[i])) {
                if (!map.get(chs[i]).equals(strs[i])) return false;
            }
            else if (map.containsValue(strs[i])) return false;
            map.put(chs[i], strs[i]);
            
            /* This is another solution.
            if (!map.containsKey(chs[i]) && !map.containsValue(strs[i])) map.put(chs[i], strs[i]);
            if (map.containsKey(chs[i]) && map.get(chs[i]).equals(strs[i])) continue;
            else return false;
            */
            
        }
        return true;
    }
}
