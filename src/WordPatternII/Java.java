    public static boolean wordPattern(String pattern, String str) {
        char[] chs = pattern.toCharArray();
        HashMap<Character, String> map = new HashMap<>();
        if (helper(chs, str, 0, 0, map)) return true;
        return false;
    }
    
    private static boolean helper(char[] chs, String str, int i, int j, HashMap<Character, String> map) {
        if (i == chs.length && j == str.length()) return true;
        if (i == chs.length || j == str.length()) return false;
        
        for (int k = j + 1; k <= str.length(); k++) {
            String s = str.substring(j, k);
            if (!map.containsKey(chs[i]) && !map.containsValue(s)) {
                map.put(chs[i], s);
                if (helper(chs, str, i + 1, k, map)) return true;
                map.remove(chs[i]);
            }
            else if (map.containsKey(chs[i]) && map.get(chs[i]).equals(s)) {
                if (helper(chs, str, i + 1, k, map)) return true;
            }
        }
        return false;
    }
