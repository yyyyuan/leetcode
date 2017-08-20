class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() == 0) return "";
        StringBuilder sb = new StringBuilder(s);
        char[] chs = s.toCharArray();
        int end = chs.length - 1;
        
        while (end > 0) {
            if (check(chs, end)) break;
            end--;
        }
        
        for (int i = end + 1; i < chs.length; i++) {
            sb.insert(0, chs[i]);
        }
        
        return sb.toString();
    }
    
    private boolean check(char[] chs, int end) {
        int start = 0;
        while (start < end) {
            if (chs[start] != chs[end]) return false;
            start++;
            end--;
        }
        return true;
    }
}
