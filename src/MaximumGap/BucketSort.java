public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int min = nums[0];
        int max = nums[0];
        
        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        
        int[] bucketsMIN = new int[nums.length - 1];
        int[] bucketsMAX = new int[nums.length - 1];
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        
        // put numbers into buckets
        for (int n : nums) {
            if (n == min || n == max) continue;
            int index = (n - min) / gap;
            bucketsMIN[index] = Math.min(n, bucketsMIN[index]);
            bucketsMAX[index] = Math.max(n, bucketsMAX[index]);
        }
        
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE) continue;
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
}
