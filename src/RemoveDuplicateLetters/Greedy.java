class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chs = s.toCharArray();
        return helper(s);
    }
    
    private String helper(String s) {
        if (s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[26];
        char[] chs = s.toCharArray();
        int pos = 0;
        for (int i = 0; i < chs.length; i++) {
            cnt[chs[i] - 'a']++;
        }
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] < chs[pos]) pos = i;
            if (--cnt[chs[i] - 'a'] == 0) break;
        }
        
        return sb.append(chs[pos]).append(helper(s.substring(pos + 1).replaceAll("" + chs[pos], ""))).toString();
    }
}
