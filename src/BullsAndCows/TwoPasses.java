class Solution {
    public String getHint(String secret, String guess) {
        char[] secs = secret.toCharArray();
        char[] gues = guess.toCharArray();
        int[] set1 = new int[10];
        int[] set2 = new int[10];
        
        for (char c : secs) set1[c - '0']++;
        for (char c : gues) set2[c - '0']++;
        
        int countA = 0;
        int countB = 0;
        
        for (int i = 0; i < gues.length; i++) {
            char c = gues[i];
            if (gues[i] == secs[i]) {
                countA++;
                set1[c - '0']--;
                set2[c - '0']--;
            }
        }
        
        for (int i = 0; i < 10; i++) {
            if (set1[i] > 0 && set2[i] > 0) countB += Math.min(set1[i], set2[i]);
        }
        
        StringBuilder result = new StringBuilder();
        result.append(countA).append("A").append(countB).append("B");
        return result.toString();
    }
}
