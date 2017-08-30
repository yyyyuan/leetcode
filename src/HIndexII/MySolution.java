class Solution {
    public int hIndex(int[] citations) {
        int count = 0;
        int index = 0;
        int n = citations.length;
        for (int i = 0; i <= citations.length; i++) {
            count = 0;
            
            // This is used to count how many papaers have citations less than i.
            while (index < citations.length && citations[index] < i) {
                index++;
                count++;
            }
            
            if (n - count < i) return i - 1;
            n -= count;
        }
        return n;
        
    }
}
