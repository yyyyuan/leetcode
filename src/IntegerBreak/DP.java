class Solution {
    // This is the solution using dynamic programming.
    public int integerBreak(int n) {
        int[] result = new int[n];
        
        // index = i + 1
        result[0] = 1;
        int index = 1;
        
        for (int i = 1; i < n; i++) {
            index = 1;
            while (index <= (i + 1) / 2) {  // We can only run half of numbers to avoid duplicate tests.
                int num = i + 1 - index;
                if (num < 4) {
                    result[i] = Math.max(result[i], index * num);
                }
                else {
                    result[i] = Math.max(result[i], index * result[num - 1]);
                }
                index++;
            }
        }
        
        return result[n - 1];
        
    }
}
