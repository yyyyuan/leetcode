class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSort(nums, 0, n - 1, n - k + 1);
    }
    
    private int quickSort(int[] nums, int lo, int hi, int k) {
        int i = lo - 1, pivot = nums[hi];
        for (int j = lo; j < hi; j++) {
            if (nums[j] <= pivot) {
                i++;
                
                // swap
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        
        // swap
        nums[hi] = nums[i + 1];
        nums[i + 1] = pivot;
        
        int m = i + 1 - lo + 1;
        
        if (m == k) return nums[i + 1];
        else if (m > k) return quickSort(nums, lo, i, k);
        else return quickSort(nums, i + 2, hi, k - m);
        
    }
}
