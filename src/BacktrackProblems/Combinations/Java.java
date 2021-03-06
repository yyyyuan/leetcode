public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), 1, n, k);
        
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        if (tempList.size() == k) result.add(new ArrayList(tempList));
        else {
            int size = tempList.size();
            if ((k - size) <= (n - start + 1)) {            // Here we could check if there is enough numbers left for combinations, if not, we will skip it. (That's much faster.)
                 for (int i = start; i <= n; i++) {
                    tempList.add(i);
                    backtrack(result, tempList, i + 1, n, k);
                    tempList.remove(tempList.size() - 1);
                }    
            } 

        }
    }
}
