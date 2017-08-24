// Not beautiful but fast.

class Solution {
    public int calculate(String s) {
        char[] chs = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        
        int result = 0;
        int number = 0;
        int status = 0; // This is used to indicate if it's in the range of multiply or division.
        int sign = 1;
        
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            if (Character.isDigit(c)) {
                number = number * 10 + Character.getNumericValue(c);
            }
            else if (c == '+') {
                if (status == 0) {
                    result += sign * number;
                    number = 0;
                    sign = 1;
                }
                else {
                    if (status == 1) {
                        result *= number;

                    }
                    else {
                        result /= number;
                    }
                    result *= stack.pop();
                    result += stack.pop();
                    status = 0;
                    sign = 1;
                    number = 0;
                }
            }
            else if (c == '-') {
                if (status == 0) {
                    result += sign * number;
                    number = 0;
                    sign = -1;
                }
                else {
                    if (status == 1) result *= number;
                    else result /= number;
                    result *= stack.pop();
                    result += stack.pop();
                    status = 0;
                    sign = -1;
                    number = 0;
                }
            }
            else if (c == '*') {
                if (status == 0) {
                    stack.push(result);
                    stack.push(sign);
                    result = number;
                    number = 0;
                    status = 1;
                    sign = 1;
                }
                else {
                    if (status == 1) {
                        result *= number;
                    }
                    else result /= number;
                    status = 1;
                    number = 0;
                }
            }
            else if (c == '/') {
                if (status == 0) {
                    stack.push(result);
                    stack.push(sign);
                    result = number;
                    number = 0;
                    status = 2;
                    sign = 1;
                }
                else {
                    if (status == 1) result *= number;
                    else result /= number;
                    status = 2;
                    number = 0;
                }
            }
        }
        
        if (number != 0) {
            if (status == 0) result += sign * number;
            else {
                if (status == 1) {
                    result *= number;
                }
                else {
                    result /= number;
                }
                
                if (!stack.isEmpty()) {
                    result *= stack.pop();
                    result += stack.pop();
                }
            }
        }
        return result;
    }
}
