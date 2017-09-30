class Solution {
    
    class TrieNode {
        char c;
        String isWord;
        int index;
        int wordIndex;
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
            
        public TrieNode() {}
            
        public TrieNode(char input, int index) {
            this.c = input;
            this.isWord = "";
            this.index = index;
            this.wordIndex = -1;
            
        }
        
        public void endWord(String word, int index) {
            this.isWord = word; // I wonder whether this should be cloned .
            this.wordIndex = index;
        }
    }
    
    
    
    private TrieNode root = new TrieNode();
    private TrieNode revRoot = new TrieNode();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<Integer> test = new ArrayList<>();
 
        root.wordIndex = -1;
        revRoot.wordIndex = -1;
        
        buildTrie(words);
        buildRevTrie(words);
        


        
        TrieNode pointer = root;
        TrieNode revPointer = revRoot;
        
        
        for (int i = 0; i < words.length; i++) {
            pointer = root;
            revPointer = revRoot;
            helper(words[i], i, pointer, revPointer);
        }
        
        return result;
    }
    
    private void helper(String word, int index, TrieNode pointer, TrieNode revPointer) {
        char[] chs = word.toCharArray();
        
        if (root.wordIndex != -1 && root.wordIndex != index) {
            if (isPalindrome(word)) {
                List<Integer> temp = new ArrayList<>();
                temp.add(pointer.wordIndex);
                temp.add(index);
                result.add(temp);
                
                temp = new ArrayList<>();
                temp.add(index);
                temp.add(pointer.wordIndex);
                result.add(temp);
            }
        }

        
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            pointer = pointer.children.get(c);
            if (revPointer.children.get(c) == null) {
                break;
            }
            revPointer = revPointer.children.get(c);
                       
            if (revPointer.wordIndex != -1 && revPointer.wordIndex != index) {
                String remain = word.substring(i + 1);
                if (isPalindrome(remain)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(index);
                    temp.add(revPointer.wordIndex);
                    if (!result.contains(temp)) result.add(temp);
                }

            }
        }
                
        pointer = root;
        revPointer = revRoot;
        
        for (int i = chs.length - 1; i >= 0; i--) {
            char c = chs[i];
            revPointer = revPointer.children.get(c);
            if (pointer.children.get(c) == null) {
                break;
            }
            pointer = pointer.children.get(c);
        
            if (pointer.wordIndex != -1 && pointer.wordIndex != index) {
                String remain = word.substring(0, i);
                if (isPalindrome(remain)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(pointer.wordIndex);
                    temp.add(index);
                    if (!result.contains(temp)) result.add(temp);
                }
            }
        }
        
    }
    
    
    public void buildTrie(String[] words) {
        for (int i = 0; i < words.length; i++) {
            addWord(words[i], i);
        }
    }
    
    public void buildRevTrie(String[] words) {
        for (int i = 0; i < words.length; i++) {
            reverseAddWord(words[i], i);
        }
    }
    
    public void addWord(String word, int index) {
        if (word.equals("")) {
            root.endWord(word, index);
            return;
        }
        
        char[] chs = word.toCharArray();
        
        TrieNode dump = root;
        
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            if (dump.children.get(c) == null) {
                dump.children.put(c, new TrieNode(c, i));
            }
            dump = dump.children.get(c);
            if (i == chs.length - 1) dump.endWord(word, index);
        }
    }
    
    public void reverseAddWord(String word, int index) {
        if (word.equals("")) {
            revRoot.endWord(word, index);
            return;
        }
        
        char[] chs = word.toCharArray();
        
        TrieNode dump = revRoot;
        
        for (int i = chs.length - 1; i >= 0; i--) {
            char c = chs[i];
            if (dump.children.get(c) == null) {
                dump.children.put(c, new TrieNode(c, i));
            }
            dump = dump.children.get(c);
            if (i == 0) dump.endWord(word, index);
        }
    }
    
    private boolean isPalindrome(String word) {
        int start = 0, end = word.length() - 1;
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) return false;
            start++;
            end--;
        }
        
        return true;
    }
}
