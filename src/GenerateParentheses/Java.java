public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generate("", list, n, n);
        return list;
    }
    
    void generate(String sublist, List<String> list, int left, int right) {
        if (left > right) return;
        if (left > 0) generate(sublist + '(', list, left-1, right);
        if (right > 0) generate(sublist + ')', list, left, right-1);
        if (left == 0 && right == 0) {
            list.add(sublist);
            return;
        }
    }
}
