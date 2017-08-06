public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        int length = 0;
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        Set<String> notVisited = new HashSet<>();
        for (String s : wordList) notVisited.add(s);
        if (!notVisited.contains(endWord)) return 0;
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            
            Set<String> temp = new HashSet<>();
            
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                
                for (int i = 0; i < chs.length; i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char old = chs[i];
                        chs[i] = ch;
                        String newWord = String.valueOf(chs);
                        
                        if (endSet.contains(newWord)) return length + 2;
                        
                        if (notVisited.contains(newWord) && wordList.contains(newWord)) {
                            notVisited.remove(newWord);
                            temp.add(newWord);
                        }
                        chs[i] = old;
                    }
                }
            }
            
            beginSet = temp;
            length++;
        }
        
        return 0;
    }
}
