/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    
    
    // Here it defines the comparator.
    class startComparator implements Comparator<Interval> {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) return intervals;
        
        Collections.sort(intervals, new startComparator());     // Here it uses this comparator to sort the list.
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> result = new LinkedList<Interval>();
        
        for (Interval i : intervals) {
            if (i.start <= end) {
                end = Math.max(i.end, end);
            }
            else {
                result.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}
