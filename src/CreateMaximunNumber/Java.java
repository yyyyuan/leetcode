// This builds 3 help function to get the result, the logic is straightforward, I should think of problem in that way.
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, result, 0)) result = candidate;
        }
        return result;
    }
    
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0, l = 0;
        while (i < m || j < n) {
            result[l++] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return result;
    }
    
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        
        return j == nums2.length || (i < nums1.length) && (nums1[i] > nums2[j]);
    }
    
    
    private int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[k];
        int len = 0;
        for (int i = 0; i < n; i++) {
            while (len > 0 && len + (n - i) > k && result[len - 1] < nums[i]) len--;
            if (len < k) result[len++] = nums[i];
        }
        return result;
    }
}
