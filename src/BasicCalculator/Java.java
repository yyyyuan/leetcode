class Solution {
    public int calculate(String s) {
        char[] chs = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        
        int result = 0;
        int sign = 1;
        int number = 0;
        
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }
            else if (c == '+') {
                result += sign * number;
                sign = 1;
                number = 0;
            }
            else if (c == '-') {
                result += sign * number;
                sign = -1;
                number = 0;
            }
            else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if (c == ')') {
                result += sign * number;
                result *= stack.pop();
                result += stack.pop();
                number = 0;
            }
        }
        
        if (number != 0) result += sign * number;
        return result;
    }
}
