public class Solution {
    public String addBinary(String a, String b) {
        String result = "";
        
        int sum = 0;
        int i = a.length()-1, j = b.length()-1;
        
        while (i>=0 || j>=0) {
            if (i>=0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j>=0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            result = sum%2 + result;
            sum = sum/2;
        }
        
        if (sum == 1) result = sum + result;
        return result;
    }
}
