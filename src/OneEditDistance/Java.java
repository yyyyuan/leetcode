public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (Math.abs(m-n) > 1) return false;
        if (Math.abs(m-n) == 1 && Math.min(m,n) == 0) return true;
        
        if (s.length() == t.length()) {
            boolean edit = false;
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (!edit) edit = true;
                    else return false;
                }
            }
            if (edit) return true;
            else return false;
        }
        
        else {
            if (s.length() < t.length()) {
                boolean edit = false;
                for (int i=0; i<t.length(); i++) {
                    if (!edit) {
                        if (i == s.length()) return true;
                        if (s.charAt(i) != t.charAt(i)) edit = true;
                    }
                    else {
                        if (s.charAt(i-1) != t.charAt(i)) return false;
                    }
                }
                return true;
            }
            else {
                boolean edit = false;
                for (int i=0; i<s.length(); i++) {
                    if (!edit) {
                        if (i == t.length()) return true;
                        if (t.charAt(i) != s.charAt(i)) edit = true;
                    }
                    else {
                        if (t.charAt(i-1) != s.charAt(i)) return false;
                    }
                }
                return true;                
            }
        }
    }
}
