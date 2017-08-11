public class Solution {
    public String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        StringBuilder result = new StringBuilder();   // Use StringBuilder here can improve the speed apparently.
        for (int i = strings.length - 1; i > 0; i--) {
            if (!strings[i].isEmpty()) {
                result.append(strings[i]);
                result.append(" ");
            }
        }
        result.append(strings[0]);
        return result.toString();
    }
}
