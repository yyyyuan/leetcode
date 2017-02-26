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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        intervals.sort(new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        for (int i=0; i<intervals.size(); i++) {
            if (intervals.get(i).end < newInterval.start) result.add(intervals.get(i));
            else if (newInterval.end >= intervals.get(i).start) {
                newInterval = new Interval (
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            }
            else result.add(intervals.get(i));
        }
        result.add(newInterval);
        
        result.sort(new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        return result;
    }
}
