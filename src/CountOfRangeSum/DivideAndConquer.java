class Solution {
    int count = 0;
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sumLeft = new long[n];
        long[] sumRight = new long[n];
        helper(sumLeft, sumRight, nums, 0, n - 1, lower, upper);
        
        return count;
    }
    
    private void helper(long[] sumLeft, long[] sumRight, int[] nums, int start, int end, int lower, int upper) {
        if (start > end) return;
        if (start == end) {
            if (nums[start] >= lower && nums[start] <= upper) count++;
            sumLeft[start] = nums[start];
            sumRight[start] = nums[start];
            return;
        }
        
        int mid = start + (end - start) / 2;
        helper(sumLeft, sumRight, nums, start, mid, lower, upper);
        helper(sumLeft, sumRight, nums, mid + 1, end, lower, upper);
        
        merge(sumLeft, sumRight, nums, start, end, lower, upper);
    }
    
    private void merge(long[] sumLeft, long[] sumRight, int[] nums, int start, int end, int lower, int upper) {

        // This part checks how many ranges meet the requirements
        check(sumLeft, sumRight, start, end, lower, upper);
        
        int mid = start + (end - start) / 2;
        
        // Now we deal with sumLeft.
        int extra = 0;
        for (int i = start; i <= mid; i++) extra += nums[i];
            
        for (int i = mid + 1; i <= end; i++) {
            sumLeft[i] += extra;
        }
        sort(sumLeft, start, end);
        
        // Now we deal with sumRight
        extra = 0;
        for (int i = mid + 1; i <= end; i++) extra += nums[i];

        for (int i = start; i <= mid; i++) {
            sumRight[i] += extra;
        }
        sort(sumRight, start, end);
        
    }
    
    private void check(long[] sumLeft, long[] sumRight, int start, int end, int lower, int upper) {
        int mid = start + (end - start) / 2;
        // we use sumRight as initializer to check
        for (int i = start; i <= mid; i++) {
            long rangeLower = (long)lower - sumRight[i];
            long rangeUpper = (long)upper - sumRight[i];
            
            findCounts(sumLeft, mid + 1, end, rangeLower, rangeUpper);
        }
    }
    
    private void findCounts(long[] sum, int l, int r, long lower, long upper) {
        int start = l, end = r;
        if (sum[l] > upper || sum[r] < lower) return;
        
        // This finds the left bound
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (sum[mid] >= lower) end = mid;
            else {
                start = mid + 1;
            }
        }
        
        int leftBound = start;
        
        start = l;
        end = r;
        
        // This finds the right bound
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (sum[mid] <= upper) start = mid;
            else end = mid - 1;
        }
        
        int rightBound = start;
        
        if (rightBound >= leftBound) count += rightBound - leftBound + 1;
    }
    
    private void sort(long[] sum, int start, int end) {
        long[] orderedSum = new long[end - start + 1];
        int mid = start + (end - start) / 2;
        int left = start, right = mid + 1;
        int index = 0;
        while (left <= mid && right <= end) {
            if (sum[left] < sum[right]) orderedSum[index++] = sum[left++];
            else orderedSum[index++] = sum[right++];
        }
        
        while (left <= mid) {
            orderedSum[index++] = sum[left++];
        }
        
        while (right <= end) {
            orderedSum[index++] = sum[right++];
        }
        
        for (int i = start; i <= end; i++) {
            sum[i] = orderedSum[i - start];
        }
        
    }
}
