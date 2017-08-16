public class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        
        int count = n / 2;
        boolean[] s = new boolean[n];
        
        for (int i = 3; i * i < n; i += 2) {
            if (s[i]) continue;
            for (int j = i * i; j < n; j += (2 * i)) {
                if (!s[j]) {
                    count--;
                    s[j] = true;
                }
            }
        }
        
        return count;
    }
}
