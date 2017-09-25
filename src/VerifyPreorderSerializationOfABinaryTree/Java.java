class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] chs = preorder.split(",");
        
        int result = isValid(chs, 0);
        return result < 0 ? false : (result == chs.length - 1);
    }
    
    private int isValid(String[] chs, int start) {
        if (start >= chs.length) return -1;
        if (chs[start].equals("#")) return start;
        
        int lastIndex = isValid(chs, start + 1);
        if (lastIndex == -1) return -1;
        return isValid(chs, lastIndex + 1);
    }
}
