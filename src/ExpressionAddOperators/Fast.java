// There are two different ways in this code, the commended out part is not fast as the code working now.
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num.length() == 0) return result;
        char[] digits = num.toCharArray();
        char[] path = new char[digits.length * 2 - 1];
        long n = 0;
        for (int i = 0; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            path[i] = digits[i];
            helper(result, path, digits, target, n, n, i + 1, i + 1);
            if (n == 0) break;
        }
//        helper(result, path, digits, target, 0, 0, 0, 0);
        return result;
    }
    
    private void helper(List<String> result, char[] path, char[] num, int target, long eval, long multed, int pos, int length) {
        if (pos == num.length) {
            if (target == eval) result.add(new String(path, 0, length));
            return;
        }
        
        long n = 0;
        int j = length + 1;
        for (int i = pos; i < num.length; i++) {
            if (i != pos && num[pos] == '0') break;
            n = n * 10 + num[i] - '0';
/*            if (pos == 0) {
                path[i] = num[i];
                helper(result, path, num, target, n, n, i + 1, i + 1);
            }
            else {
*/                path[j++] = num[i];
                path[length] = '+';
                helper(result, path, num, target, eval + n, n, i + 1, j);
                path[length] = '-';
                helper(result, path, num, target, eval - n, -n, i + 1, j);
                path[length] = '*';
                helper(result, path, num, target, eval - multed + multed * n, multed * n, i + 1, j);                
//            }

        }
    }
}
