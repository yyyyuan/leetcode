public class Solution {
    public String addBinary(String a, String b) {
        String result = "";
        
        int carry = 0, sum = 0;
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
            carry = sum%2;
            sum = sum/2;
            
            result += carry;
        }
        
        if (sum == 1) result += sum;
        
        String reverseResult = "";
        for (int k=result.length()-1; k>=0; k--) {
            reverseResult += result.charAt(k);
        }
        
        return reverseResult;
    }
}
