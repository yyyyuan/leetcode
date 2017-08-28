class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c =='*') {
                String a = input.substring(0, i);
                String b = input.substring(i + 1);
                List<Integer> al = diffWaysToCompute(a);
                List<Integer> bl = diffWaysToCompute(b);
                
                for (int x : al) {
                    for (int y : bl) {
                        if (c == '+') result.add(x + y);
                        if (c == '-') result.add(x - y);
                        if (c == '*') result.add(x * y);
                    }
                }
            }
        }
        if (result.size() == 0) result.add(Integer.valueOf(input));
        return result;
    }
}
