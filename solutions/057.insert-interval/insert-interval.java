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
        int i = 0;
        boolean added = false;
        for(;i < intervals.size();i++){
            Interval cur = intervals.get(i);
            if(cur.end < newInterval.start){
                result.add(cur);
            }else if(cur.start <= newInterval.start && cur.end < newInterval.end  ){
                //后面的情况里 cur.end >= newInterval.start
                newInterval.start = cur.start;
            }else if(cur.start <= newInterval.start && newInterval.end <= cur.end){
                added = true;
                for(;i < intervals.size();i++) result.add(intervals.get(i));
                break;
            }else if(cur.start > newInterval.start && newInterval.end > cur.end){
                continue;
            }else if(cur.start > newInterval.start && newInterval.end <= cur.end && newInterval.end >= cur.start){
                newInterval.end = cur.end;
            }else{
                result.add(newInterval);
                added = true;
                for(;i < intervals.size();i++) result.add(intervals.get(i));
                break;
            }
        }
        if(!added){
            result.add(newInterval);
        }
        return result;
    }
}