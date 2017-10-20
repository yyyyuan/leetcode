class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        char[] chs = s.toCharArray();
        int start = 0, end = chs.length - 1;
        
        while (start < end) {
            while (start < end && !set.contains(chs[start])) start++;
            while (start < end && !set.contains(chs[end])) end--;
            
            // switch
            if (start < end) {
                char temp = chs[start];
                chs[start] = chs[end];
                chs[end] = temp;
                start++;
                end--;
            }
            
        }
        
        return new String(chs);
    }
}
