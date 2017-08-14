public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        int[] result = new int[2];
        while (start < end) {
            int v = numbers[start] + numbers[end];
            if (v == target) return new int[] {start + 1, end + 1};
            else if (v > target) end--;
            else start++;
        }
        return result;
    }
}
