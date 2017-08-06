public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0 ) return 0;
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> ladder = new HashMap<>();
        for (String s : wordList) ladder.put(s, Integer.MAX_VALUE);
        ladder.put(beginWord, 0);
        queue.offer(beginWord);
        int min = Integer.MAX_VALUE;
        
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
                        
                        if (newWord.equals(endWord)) {
                            min = step;
                        }
                    }
                }
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min + 1;
    }
}
