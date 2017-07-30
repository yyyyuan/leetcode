public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) list.add(i ^ (i >> 1));    // Here it uses the relationship: G(i) = i ^ (i >> 1)
        return list;
    }
}

