public class Solution {
    List<List<String>> lists;
    Map<String, List<String>> map;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        lists = new ArrayList<>();
        if (wordList.size() == 0) return lists;
        
        map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Map<String, Integer> ladder = new HashMap<>();
        
        for (String s : wordList) ladder.put(s, Integer.MAX_VALUE);
        ladder.put(beginWord, 0);
        
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word) + 1;
            if (step > min) break;
            
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i, ch);
                    String newWord = builder.toString();
                    if (ladder.containsKey(newWord)) {
                        if (step > ladder.get(newWord)) continue;
                        else if (step < ladder.get(newWord)) {
                            queue.add(newWord);
                            ladder.put(newWord, step);
                        }
                        
                        if (map.containsKey(newWord)) map.get(newWord).add(word);
                        else {
                            List<String> list = new ArrayList<>();
                            list.add(word);
                            map.put(newWord, list);
                        }
                        
                        if (newWord.equals(endWord)) min = step;
                    }
                }
            }
        }
        
        List<String> list = new ArrayList<>();
        backtrack(endWord, beginWord, list);
        return lists;
    }
    
    private void backtrack(String end, String start, List<String> list) {
        if (end.equals(start)) {
            list.add(0, start);
            lists.add(new ArrayList(list));
            list.remove(0);
            return;
        }
        list.add(0, end);    
        if (map.get(end) != null) {
            for (String s : map.get(end)) backtrack(s, start, list);
        }
        list.remove(0);
    }
}
