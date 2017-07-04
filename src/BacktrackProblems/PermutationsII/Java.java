public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] check) {
        if (tempList.size() == nums.length) list.add(new ArrayList<>(tempList));
        else {
            for (int i=0; i<nums.length; i++) {
                if (check[i] == true || i > 0 && nums[i] == nums[i-1] && !check[i-1]) continue; // This line of code handles the duplicate elements.
                tempList.add(nums[i]);
                check[i] = true;
                backtrack(list, tempList, nums, check);
                tempList.remove(tempList.size() - 1);
                check[i] = false;
            }
        }
    }
}
