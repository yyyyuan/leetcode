class Solution {
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
    
    public TrieNode root = new TrieNode(' ');

    
    public void addWord(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!ws.children.containsKey(ch)) ws.children.put(ch, new TrieNode(ch));
            ws = ws.children.get(ch);
        }
        ws.isWord = true;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) addWord(word);
        
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(result, board, i, j, root, new StringBuilder());
            }
        }
        
        return result;
    }
    
    private void search(List<String> result, char[][] board, int i, int j, TrieNode ws, StringBuilder word) {
        if (ws.isWord) {
            ws.isWord = false;
            result.add(word.toString());
        } 
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        
        char ch = board[i][j];
        if (!ws.children.containsKey(ch)) return;
        else {
            TrieNode temp = ws;
            ws = ws.children.get(ch);
            word.append(ch);
            board[i][j] ^= 256;
            search(result, board, i + 1, j, ws, word);
            search(result, board, i - 1, j, ws, word);
            search(result, board, i, j + 1, ws, word);
            search(result, board, i, j - 1, ws, word);

            board[i][j] ^= 256;
            ws = temp;
            word.deleteCharAt(word.length() - 1);
        }
    }
}
