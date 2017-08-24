// This is a very straightforward solution.
class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<String>();
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int min = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == max + 1) max = max + 1;
            else {
                if (min == max) result.add(sb.append(min).toString());
                else {
                    sb.append(min);
                    sb.append("->");
                    sb.append(max);
                    result.add(sb.toString());                    
                }

                sb = new StringBuilder();
                min = nums[i];
                max = nums[i];
            }
        }
        
        if (min == max) result.add(sb.append(min).toString());
        else {
            sb.append(min);
            sb.append("->");
            sb.append(max);
            result.add(sb.toString());        
        }
        return result;
    }
}
