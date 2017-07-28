public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        
        int[] letters = new int[58];    // Here I use 58 to include upper case letters
        
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'A']++;    // So we minus 'A' instead of 'a' here.
            letters[s2.charAt(i) - 'A']--;
        }
        for (int i = 0; i < 58; i++) if (letters[i] != 0) return false;
        
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
            
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) return true;
        }
        
        return false;
    }
}
