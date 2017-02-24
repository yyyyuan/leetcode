public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
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
