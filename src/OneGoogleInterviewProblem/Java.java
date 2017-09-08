// Given 4-Integer array, e.g., [4,1,8,7], check if it can calculate to 24
// Here it can (8 - 4) * (7 - 1) = 24, the order of numbers in the array is not important.

class Main {
    
    public static boolean sum24(int[] nums) {
        HashSet<Integer> result = helper(nums, new HashSet<Integer>(), 4);
        return result.contains(24);
    }
    
    private static HashSet<Integer> helper(int[] nums, HashSet<Integer> set, int n) {
        HashSet<Integer> result = new HashSet<>();
        HashSet<Integer> temp = new HashSet(set);      // Copy the set
        
        if (n == 1) {
            for (int num : nums) {
                if (set.contains(num)) continue;
 //               set.add(num);
                result.add(num);
            } 
            return result;
        }

        for (int i = 1; i < n; i++) {
            set = new HashSet(temp);        // Copy the set
            HashSet<Integer> h1 = helper(nums, set, i);
            HashSet<Integer> h2 = helper(nums, set, n - i);
            
            for (int x : h1) {
                for (int y : h2) {
                    result.add(x * y);
                    result.add(x - y);
                    result.add(y - x);
                    result.add(x + y);
                    if (x != 0) result.add(y / x);
                    if (y != 0) result.add(x / y);
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        
        int[] array = {1,1,1,1};
        boolean result = sum24(array);
        System.out.println(result);
        System.out.println("Hello World!");
    }
}
