class Solution {
    public boolean isAdditiveNumber(String num) {
        long first = 0, second = 0;
// This is my solution
/*        for (int i = 0; i < num.length() - 2; i++) {
            first = Long.valueOf(num.substring(0, i + 1));
            for (int j = i + 1; j < num.length() - 1; j++) {
                second = Long.valueOf(num.substring(i + 1, j + 1));
                if (helper(num, first, second, j + 1)) return true;
                if (num.charAt(i + 1) == '0') break;
            }
            if (num.charAt(0) == '0') break;
        }
*/        
        for (int i = 0; i < num.length() / 2; i++) { // This seems to skip more useless cases.
            first = Long.valueOf(num.substring(0, i + 1));
            for (int j = i + 1; j < num.length() - (num.length() - i) / 2; j++) {
                second = Long.valueOf(num.substring(i + 1, j + 1));
                if (helper(num, first, second, j + 1)) return true;
                if (num.charAt(i + 1) == '0') break;
            }
            if (num.charAt(0) == '0') break;
        }
        return false;
    }
    
    private boolean helper(String num, long first, long second, int index) {
        if (index == num.length()) return true;
        
        for (int j = index; j < num.length(); j++) {
            String s = num.substring(index, j + 1);
            long n = Long.valueOf(s);
            if (first + second == n) {
                if (helper(num, second, n, j + 1)) return true;
            }
            if (num.charAt(index) == '0') break;
        }
        return false;
    }
}
