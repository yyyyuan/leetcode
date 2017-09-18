class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        double a = Math.log(n) / Math.log(3);
        double b = Math.pow(3, Math.ceil(a));
        return b == n;
    }
}





class Solution {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
