public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        HashSet<String> skip = new HashSet<String>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String result = "";
        for (String s : stack) result = result + "/" + s;
        return result.isEmpty() ? "/" : result;
    }
}
