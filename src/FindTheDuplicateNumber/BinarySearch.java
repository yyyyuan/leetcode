class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) return nums[mid];
            if (mid + 1 < nums.length && nums[mid + 1] == nums[mid]) return nums[mid];
            if (nums[mid] >= mid + 1) start = mid;
            else end = mid;
        }
        return -1;
    }
}
