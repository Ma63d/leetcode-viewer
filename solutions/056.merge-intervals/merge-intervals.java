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
    public class MyComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval a,Interval b){
            return a.start - b.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.size() == 0) return result; 
        Collections.sort(intervals,new MyComparator());
        Interval last = intervals.get(0);
        for(int i = 1;i < intervals.size();i++){
            Interval cur = intervals.get(i);
            if(cur.start <= last.end ){
                if(cur.end > last.end){
                    last.end = cur.end;    
                }else{
                    continue;
                }
            }else{
                result.add(last);
                last = cur;
            }
        }
        result.add(last);
        return result;
    }
}