public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            int size = list.size();
            for (int j = size - 1; j >= 0; j--) list.add(list.get(j) | 1 << i);   // We get the results of n based on n - 1.
        }
        
        return list;
    }
}
