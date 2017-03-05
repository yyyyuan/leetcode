// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 0) return 0;
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        
        for (int i=0; i<A.length; i++) {
            sum += A[i];
            map.put(i, sum);
        }
        
        if (map.get(A.length-1) - map.get(0) == 0) result++;
        
        for (int i=1; i<A.length; i++) {
            if (map.get(i-1) == map.get(A.length-1) - map.get(i)) result++;    
        }
        
        return result;
    }
}
