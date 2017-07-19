public class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n+1];
        int sum = 1;
        StringBuilder sb = new StringBuilder();
        
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        
        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<=n; i++){
            numbers.add(i);
        }
        
        k--;

        
        for (int i = 1; i <= n; i++) {
            int index = k/factorial[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }
        
        return sb.toString();
    }
}
