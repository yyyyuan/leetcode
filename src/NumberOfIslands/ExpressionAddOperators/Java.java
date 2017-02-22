public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        helper(result, "", target, num, 0, 0, 0);
        return result;
    }
    
    public void helper(List<String> result, String path, int target, String num, int pos, long eval, long product) {
        if (pos == num.length()) {
            if (eval == target) {
                result.add(path);
            }
            return;
        }
        
        for (int i=pos; i<num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long curr = Long.parseLong(num.substring(pos, i+1));
            if (pos == 0) {
                helper(result, path+curr, target, num, i+1, curr, curr);
            }
            else {
                helper(result, path + '+' + curr, target, num, i+1, eval+curr, curr);
                helper(result, path + '-' + curr, target, num, i+1, eval-curr, -curr);
                helper(result, path + '*' + curr, target, num, i+1, eval - product + product*curr, product*curr);
            }
            
        }
    }
}
