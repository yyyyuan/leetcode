class Solution {
    public String shortestPalindrome(String s) {
        int j = 0;
        char[] chs = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (chs[i]== chs[j]) j++;
        }
        if (j == s.length()) return s;
        
        // s.subtring(j) is 100% not a part of palindrome so we need to reverse this part.
        return new StringBuilder(s.substring(j)).reverse().toString() + shortestPalindrome(s.substring(0, j)) + s.substring(j);
    }
}
