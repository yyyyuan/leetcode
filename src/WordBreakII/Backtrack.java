public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (!canBreak(s, wordDict)) return result;
        Set<String> dict = new HashSet<>();
        for (String string : wordDict) dict.add(string);
        backtrack(result, new StringBuilder(), s, dict, 0);
        
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder temp, String s, Set<String> dict, int index) {
        if (index == s.length()) {
            result.add(temp.substring(1));
            return;
        }
        
            for (int i = index; i < s.length(); i++) {
                StringBuilder copy = new StringBuilder(temp);
                if (dict.contains(s.substring(index, i + 1))) {
                    temp.append(" ");
                    temp.append(s.substring(index, i + 1));
                    backtrack(result, temp, s, dict, i + 1);
                }
                temp = copy;
            }
    }
    
    private boolean canBreak(String s, List<String> wordDict) {
        boolean[] map = new boolean[s.length()+1];
        map[0] = true;
        for (int i=0; i<s.length(); i++) {
            if (map[i]) {
                for (int j=i; j<s.length(); j++) {
                    if (wordDict.contains(s.substring(i,j+1))) map[j+1] = true;
                }
            }
        }
        
        return map[s.length()];
    }
}
