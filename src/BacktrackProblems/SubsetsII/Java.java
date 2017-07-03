// There are duplicate numbers in the array, it can't reuse the same element.
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void backTrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        result.add(new ArrayList<Integer>(temp));
        for (int i=start; i<nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue; // Here will check if this is the duplicate element
            temp.add(nums[i]);
            backTrack(result, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
    
}
