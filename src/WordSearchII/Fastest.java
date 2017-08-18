class Solution {
    class TrieNode {
        String isWord;
        TrieNode[] children = new TrieNode[26];
//        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        
        public TrieNode() {};
    }
    
    public TrieNode root = new TrieNode();
    
    public void addWord(String word) {
        char[] chs = word.toCharArray();
        TrieNode ws = root;
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if (ws.children[ch - 'a'] == null) ws.children[ch - 'a'] = new TrieNode();
            ws = ws.children[ch - 'a'];
        }
        ws.isWord = word;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) addWord(word);
        
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(result, board, i, j, root);
            }
        }
        
        return result;
    }
    
    private void search(List<String> result, char[][] board, int i, int j, TrieNode ws) {
        char ch = board[i][j];
        if (ch == '#' || ws.children[ch - 'a'] == null) return;

        ws = ws.children[ch - 'a'];
        if (ws.isWord != null) {
            result.add(ws.isWord);
            ws.isWord = null;
        } 
        
        board[i][j] = '#';
        if (i < board.length - 1) search(result, board, i + 1, j, ws);
        if (i > 0) search(result, board, i - 1, j, ws);
        if (j < board[0].length - 1) search(result, board, i, j + 1, ws);
        if (j > 0) search(result, board, i, j - 1, ws);

        board[i][j] = ch;
    }
}
