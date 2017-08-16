public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        
        while (n != 1) {
            int result = 0;
            while (n != 0) {
                result += Math.pow((n % 10), 2);
                n /= 10;
            }
            n = result;
            if (!set.add(result)) return false;
        }
        return true;
    }
}
