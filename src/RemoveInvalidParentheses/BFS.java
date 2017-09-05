class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();
        int weave = 0;
        int rmL = 0, rmR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') rmL++;
            else if (s.charAt(i) == ')') {                
                if (rmL != 0) rmL--;
                else rmR++;
            }
        }
        int count = s.length() - Math.abs(weave);
        dfs(result, new StringBuilder(), s, 0, rmL, rmR, 0);
        return new ArrayList<String>(result);
    }
    
    private void dfs(Set<String> result, StringBuilder sb, String s, int index, int rmL, int rmR, int open) {
        if (open < 0 || rmL < 0 || rmR < 0) return;
        if (index == s.length()) {
            if (rmL == 0 && rmR == 0 && open == 0) result.add(sb.toString());
            return;
        }
        char c = s.charAt(index);
        int len = sb.length();
        if (c == '(') {
            dfs(result, sb, s, index + 1, rmL - 1, rmR, open);
            dfs(result, sb.append(c), s, index + 1, rmL, rmR, open + 1);
        }
        else if (c == ')') {
            dfs(result, sb, s, index + 1, rmL, rmR - 1, open);
            dfs(result, sb.append(c), s, index + 1, rmL, rmR, open - 1);
        }
        else dfs(result, sb.append(c), s, index + 1, rmL, rmR, open);
        
//        sb.deleteCharAt(sb.length() - 1);
        sb.setLength(len);
    }
}
