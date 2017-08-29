class Solution {
    public int nthUglyNumber(int n) {
        int[] k = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        k[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Math.min(k[index2] * 2, Math.min(k[index3] * 3, k[index5] * 5));
            if (min == k[index2] * 2) index2++;
            if (min == k[index3] * 3) index3++;
            if (min == k[index5] * 5) index5++;
            k[i] = min;
        }
        return k[n - 1];
    }
}
