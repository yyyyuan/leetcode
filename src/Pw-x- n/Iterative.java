public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        long i = Math.abs((long)n);     // Use long to handle the special case of Integer.MIN_VALUE
        
        double result = 1;
        while (i > 0) {
            if (i % 2 != 0) result *= x;
//          if ((i & 1) == 1) result *= x;      // This can also work using bit operations.

            x *= x;
            i >>= 1;
        }
        
        return n < 0 ? 1.0 / result : result;
    }
}
