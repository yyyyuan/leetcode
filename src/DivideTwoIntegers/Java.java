public class Solution {
    public int divide(int dividend, int divisor) {
        long count = 0;
        int sign = 1;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) sign = -1;
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);
        count = lDivide(longDividend, longDivisor);
        
        if (count > Integer.MAX_VALUE) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        else return ((int) count) * sign;
    }
    
    private long lDivide(long longDividend, long longDivisor) {
        if (longDividend < longDivisor) return 0;
        long sum = longDivisor;
        long multiple = 1;
        while((sum+sum) < longDividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + lDivide(longDividend - sum, longDivisor);
    }
}
