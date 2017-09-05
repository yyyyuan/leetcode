class NumArray {
    int[] map;
    public NumArray(int[] nums) {
        map = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map[i] = sum;
        }
    }
    
    public int sumRange(int i, int j) {
//        return (i == 0) ? map[j] : map[j] - map[i - 1];
        if (i == 0) return map[j];
        else return map[j] - map[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
