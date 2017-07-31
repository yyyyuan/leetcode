public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", s, 0, 0);
        
        return result;
    }
    
    private void backtrack(List<String> result, String ip, String s, int count, int idx) {
        if (count > 4) return;
        if (count == 4 && idx == s.length()) result.add(ip);
        
        for (int i = 1; i < 4; i++) {
            if (idx + i > s.length()) break;
            String temp = s.substring(idx, idx + i);
            if (temp.charAt(0) == '0' && temp.length() > 1 || i == 3 && Integer.parseInt(temp) >= 256) continue;
            backtrack(result, ip + temp + (count == 3 ? "" : "."), s, count + 1, idx + i);
        }
    }
}
