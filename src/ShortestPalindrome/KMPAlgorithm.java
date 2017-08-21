class Solution {
    public String shortestPalindrome(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);
        
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }
    
    private int[] getTable(String s) {
        char[] chs = s.toCharArray();
        int[] lps= new int[s.length()];
        int i = 1;
        int len = 0;
        lps[0] = 0;
        
        while (i < s.length()) {
            if (chs[i] == chs[len]) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if (len > 0) {
                    len = lps[len - 1];
                }
                else if (len == 0) {
                    lps[i] = len;
                    i++;
                }
            }
        }
        
        return lps;
    }
}
