class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        int number = n;
        int digit;
        int result = 0;
        int k = 1;
        int remains = 0;
        
        while (n != 0) {
            remains = number % k;
            digit = n % 10;
            n = n / 10;
                                    
            if (digit == 0) result += n;
            else result += n + 1;
            
            if (digit == 0) result += (n) * (k - 1);
            else if (digit == 1) result += remains + n * (k - 1);
            else result += (k - 1) * (n + 1);
            
            k *= 10;
        }
        
        return result;
        
    }
}
