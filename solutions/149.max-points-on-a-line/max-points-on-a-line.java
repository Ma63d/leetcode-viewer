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
        HashMap<String, Integer> lines = new HashMap<String, Integer>();
        int maxPoints = 0;
        String slope;
        
        for(int i = 0; i < points.length; i++) {
            int samePoint = 1;
            
            for(int j = i+1; j < points.length; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if(x == 0 && y == 0) {
                    samePoint++;
                }
                else {
                    int gcd = gcd(x, y);
                    System.out.println(x + "_" + y);
                    x /= gcd;
                    y /= gcd;
                    slope = x + "_" + y;
                    
                    lines.put(slope, lines.getOrDefault(slope, 0) + 1);
                }
            }
            
            maxPoints = Math.max(maxPoints, samePoint + max(lines.values().toArray()));
            lines.clear();
        }
        
        return maxPoints;
    }
    
    private int max(Object... args) {
        int max = 0;
        for(int i = 0; i < args.length; i++) {
            max = Math.max(max, (int)args[i]);
        }
        
        return max;
    }
    
    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}