public class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int n : nums) set.add(n);
        
        for (int n : nums) {
            if (set.remove(n)) {
                int val = n;
                int sum = 1;
                while (set.remove(val - 1)) val--;
                sum += n - val;
                
                val = n;
                while (set.remove(val + 1)) val++;
                sum += val - n;
                
                result = Math.max(result, sum);
            }
        }
        
        return result;
    }
}
