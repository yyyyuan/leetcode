class Solution {

    // This is going to reverse the char array using two pointers directly.
    public String reverseString(String s) {
        char[] chs = s.toCharArray();
        int start = 0, end = chs.length - 1;
        
        while (start < end) {
            char temp = chs[start];
            chs[start] = chs[end];
            chs[end] = temp;
            start++;
            end--;
        }
        
    
        return new String(chs);
    }
}
