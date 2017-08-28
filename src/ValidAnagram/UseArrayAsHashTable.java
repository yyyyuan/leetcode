class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        for (int i = 0; i < sa.length; i++) map[sa[i] - 'a']++;
        for (int i = 0; i < ta.length; i++) map[ta[i] - 'a']--;
        for (int i = 0; i < 26; i++) if (map[i] != 0) return false;
        return true;
    }
}
