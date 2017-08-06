public class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int n : nums) set.add(n);
        
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int right = n + 1;
                while (set.contains(right)) right++;
                result = Math.max(result, right - n);
            }
        }
        
        return result;
    }
}
