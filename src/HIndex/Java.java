class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        int[] map = new int[citations.length + 1];
        int length = citations.length;
        for (int n : citations) {
            if (n > length) {
                map[length]++;
            }
            else map[n]++;
        }
        
        int count = 0;
        
        for (int i = 0; i < map.length; i++) {
            if (length - count >= i) {
                count += map[i];
            }
            else return i - 1;
        }
        return map[length];
    }
}
