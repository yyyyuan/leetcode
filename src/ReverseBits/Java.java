public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // It must do an unsigned shift.
            if (i < 31) result <<= 1;
        }
        return result;
    }
}
