public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        long i = Math.abs((long)n);
        
        double result = 1;
        while (i > 0) {
            if (i % 2 != 0) result *= x;
            x *= x;
            i >>= 1;
        }
        
        return n < 0 ? 1.0 / result : result;
    }
}
