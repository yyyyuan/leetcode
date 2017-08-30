class Solution {
    public int hIndex(int[] citations) {
        int start = 0, end = citations.length - 1;
        int n = citations.length;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (citations[mid] == (n - mid)) return n - mid;
            else if (citations[mid] > (n - mid)) end = mid - 1;
            else start = mid + 1;
        }
        return n - start;
    }
}
