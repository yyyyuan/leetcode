public class Solution {
    private int maxLength = 0, start = 0;
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            findPalindrome(s, i, i);
            findPalindrome(s, i, i + 1);
        }
        
        return s.substring(start, start + maxLength);
    }
    
    private void findPalindrome(String s, int lo, int hi) {
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--;
            hi++;
        }
        if (hi - lo - 1 > maxLength) {
            start = lo + 1;
            maxLength = hi - lo - 1;
        }
    }
}
