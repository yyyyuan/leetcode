/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length == 0) return 0;
        int max = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int j = 0; j < points.length; j++) {
            map.clear();
            int count = 0;
            Point start = points[j];
            int overlapped = 0;
        
            for (int i = j + 1; i < points.length; i++) {
                int x = points[i].x - start.x;
                int y = points[i].y - start.y;
                int gcd = generateGCD(x, y);
                
                if (x == 0 && y == 0) {
                    overlapped++;
                    continue;
                }
                
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }
                
                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                        map.put(x, map.get(x));
                    }
                    else {
                        map.get(x).put(y, 1);
                        map.put(x, map.get(x));
                    }
                }
                else {
                    Map<Integer, Integer> temp = new HashMap<>();
                    temp.put(y, 1);
                    map.put(x, temp);
                }
                count = Math.max(count, map.get(x).get(y));
            }
            max = Math.max(max, count + overlapped);
        }
    
        max++;
        return max;
    }
    
    private int generateGCD(int a, int b){
        if (b == 0) return a;
        else return generateGCD(b, a%b);
    }
}
