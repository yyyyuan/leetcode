public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, candidates, new ArrayList<>(), target, 0);
        
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, int[] candidates, List<Integer> tempList, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i<candidates.length; i++) {
                tempList.add(candidates[i]);
                backtrack(list, candidates, tempList, remain - candidates[i], i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
