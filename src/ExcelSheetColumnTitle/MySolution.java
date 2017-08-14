public class Solution {
    public String convertToTitle(int n) {
        String[] dict = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", 
                                  "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        
        int remain = n - 1;
//        if (remain == 0) return "A";
        StringBuilder result = new StringBuilder();
        
        while (remain >= 0) {
            int index = remain % 26;
            result.insert(0, dict[index]);
            remain = (remain - index) / 26 - 1;
        }
        return result.toString();
    }
}
