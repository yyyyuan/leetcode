public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        
        int i = nums.length-1;
        
        for (; i>=1; --i) {
            if (nums[i] > nums[i-1]) break;
        }
        
        if (i != 0) {
            swap(nums, i-1);
        }
        
        reverse(nums, i);
    }
    
    private void swap(int[] a, int i) {
        for (int j=a.length-1; j>i; --j) {
            if (a[j] > a[i]) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                break;
            }
        }
    }
    
    private void reverse(int[] nums, int i) {
        int first = i;
        int last = nums.length - 1;
        while (first < last) {
            int temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp;
            first++;
            last--;
        }
    }
}
