// In this problem we use bit manipulation to check if two strings have the same character.
class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int[] bytes = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int val = 0;
            String = words[i];
            for (int j = 0; j < word.length(); j++) {
                val |= 1 << (word.charAt(j) - 'a');
            }
            bytes[i] = val;
        }
        
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bytes[i] & bytes[j]) == 0) max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }
}
