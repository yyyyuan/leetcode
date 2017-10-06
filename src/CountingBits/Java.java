class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int pow = 1;
        
        for (int i = 1; i <= num; i++) {
            if (i < pow * 2) {
                result[i] = 1 + result[i - pow];
            }
            else if (i == pow * 2) {
                result[i] = 1;
                pow *= 2;
            }
        }
        
        return result;
    }
}
