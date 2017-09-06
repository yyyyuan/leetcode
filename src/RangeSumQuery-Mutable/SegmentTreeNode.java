class NumArray {
    
    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;
        
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
    
    SegmentTreeNode root = null;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start > end) return null;
        if (start == end) {
            node.sum = nums[start];
            return node;
        }
        else {
            int mid = start + (end - start) / 2;
            SegmentTreeNode left = buildTree(nums, start, mid);
            SegmentTreeNode right = buildTree(nums, mid + 1, end);
            node.left = left;
            node.right = right;
            node.sum = left.sum + right.sum;
            return node;
        }
        
    }
    
    public void update(int i, int val) {
        updateUtil(root, i, val);
    }
    
    private void updateUtil(SegmentTreeNode root, int i, int val) {
        if (i < root.start) return;
        if (i > root.end) return;
        
        int start = root.start, end = root.end;
        if (start == end && i == start) root.sum = val;
        else {
            updateUtil(root.left, i, val);
            updateUtil(root.right, i, val);
            root.sum = root.left.sum + root.right.sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return sumUtil(root, i, j);
    }
    
    private int sumUtil(SegmentTreeNode root, int i, int j) {
        if (i > root.end || j < root.start) return 0;
        int start = root.start, end = root.end;
        if (i == start && j == end) return root.sum;
        else {
            int mid = start + (end - start) / 2;
            if (j <= mid) return sumUtil(root.left, i, j);
            if (i > mid) return sumUtil(root.right, i, j);
            else {
                int left = sumUtil(root.left, i, mid);
                int right = sumUtil(root.right, mid + 1, j);
                return left + right;                
            }
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
