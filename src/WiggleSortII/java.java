class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int location = (n + 1) / 2;
        int median = findKthLargest(nums, location);
        
        int right = 1, left = (n % 2 == 0) ? n - 2 : n - 1;
//        int left = 0, right = (n % 2 == 0) ? n - 1 : n - 2;
        int end = right;
        
        for (int i = left; i >= 0; i -= 2) {
            if (nums[i] < median) {
                swap(nums, left, i);
                left -= 2;
            }
        }
        
        for (int i = (n % 2 == 0) ? n - 1 : n - 2; i >= 0; i -= 2) {
            if (nums[i] < median) {
                swap(nums, left, i);
                left -= 2;
            }
        }
        
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] > median) {
                swap(nums, right, i);
                right += 2;
            }
        }
        
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] > median) {
                swap(nums, right, i);
                right += 2;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private int findKthLargest(int[] nums, int k) {
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
