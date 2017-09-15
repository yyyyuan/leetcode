class Solution {
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) return result;
        
        count = new int[nums.length];
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) indexes[i] = i;
        
        
        mergeSort(nums, indexes, 0, nums.length - 1);
        
        for (int n : count) result.add(n);
        
        return result;
    }
    
    private void mergeSort(int[] nums, int[] indexes, int start, int end) {
        if (start >= end) return;
        
        int mid = start + (end - start) / 2;
        mergeSort(nums, indexes, start, mid);
        mergeSort(nums, indexes, mid + 1, end);
        
        merge(nums, indexes, start, end);
    }
    
    private void merge(int[] nums, int[] indexes, int start, int end) {
        
        int mid = start + (end - start) / 2;
        int left_index = start, right_index = mid + 1;
        int[] new_indexes = new int[end - start + 1];
        int rightCount = 0;
        int sort_index = 0;
        
        while (left_index <= mid && right_index <= end) {
            if (nums[indexes[right_index]] < nums[indexes[left_index]]) {
                new_indexes[sort_index] = indexes[right_index];
                rightCount++;
                right_index++;
            }
            else {
                new_indexes[sort_index] = indexes[left_index];
                count[indexes[left_index]] += rightCount;
                left_index++;
            }
            sort_index++;
        }
        
        while (left_index <= mid) {
            new_indexes[sort_index] = indexes[left_index];
            count[indexes[left_index]] += rightCount;
            sort_index++;
            left_index++;
        }
        
        while (right_index <= end) {
            new_indexes[sort_index++] = indexes[right_index++];
        }

        
        for (int i = start; i <= end; i++) {
            indexes[i] = new_indexes[i - start];
        }
    }
}
