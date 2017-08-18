class WordDictionary {
    class TrieNode {
        char val;
        boolean isWord;
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        
        public TrieNode() {};
        public TrieNode(char val) {
            TrieNode node = new TrieNode();
            node.val = val;
        }
    }
    
    public TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!ws.children.containsKey(ch)) {
                ws.children.put(ch, new TrieNode(ch));
            }
            ws = ws.children.get(ch);
        }
        ws.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word.length() == 0) return true;
        TrieNode ws = root;
        return searchHelp(ws, word, 0);
    }
    
    private boolean searchHelp(TrieNode ws, String word, int index) {
        if (index == word.length()) return ws.isWord;
        
        char ch = word.charAt(index);
        if (ch == '.') {
            for (char child : ws.children.keySet()) {
                if (searchHelp(ws.children.get(child), word, index + 1)) return true;
            }
            return false;
        }
        else {
            if (!ws.children.containsKey(ch)) return false;
            else return searchHelp(ws.children.get(ch), word, index + 1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
