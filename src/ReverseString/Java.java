class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        
        char[] chs = s.toCharArray();
        
        for (int i = chs.length - 1; i >= 0; i--) sb.append(chs[i]);
        
        return sb.toString();
    }
}
