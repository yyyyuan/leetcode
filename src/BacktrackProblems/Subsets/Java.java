public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<Integer>();
        backTrack(result, temp, nums, 0);
        return result;
    }

    
    public void backTrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        result.add(new ArrayList<Integer>(temp));
        for (int i=start; i<nums.length; i++) {
            temp.add(nums[i]);
            backTrack(result, temp, nums, i+1);
            temp.remove(temp.get(temp.size()-1));
        }
    }
}
