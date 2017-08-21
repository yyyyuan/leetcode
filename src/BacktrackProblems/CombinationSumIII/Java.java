class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), n, k, 1);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int target, int count, int index) {
        if (count < 0 || target < 0) return;
        if (count == 0 && target == 0) {
            result.add(new ArrayList(tempList));
        }
        
        for (int i = index; i <= 9; i++) {
            tempList.add(i);
            backtrack(result, tempList, target - i, count - 1, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
