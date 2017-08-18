class WordDictionary {
    class TrieNode {
        char val;
        boolean isWord;
//        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        TrieNode[] children = new TrieNode[26];
        
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
            if (ws.children[ch - 'a'] == null) ws.children[ch - 'a'] = new TrieNode(ch);
            ws = ws.children[ch - 'a'];
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
            for (TrieNode node : ws.children) {
                if (node != null) {
                    if (searchHelp(node, word, index + 1)) return true;
                }
            }
            return false;
        }
        else {
            if (ws.children[ch - 'a'] == null) return false;
            else return searchHelp(ws.children[ch - 'a'], word, index + 1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
