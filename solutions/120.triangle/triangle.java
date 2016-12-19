public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() < 1) return 0;
        List<Integer> lastTriangle = triangle.get(0);
        int min = lastTriangle.get(0);
        for(int i = 1;i < triangle.size();i++){
            int curMin = 0;
            List<Integer> curTriangle = triangle.get(i);
            for(int j = 0;j < curTriangle.size();j++){
                if(j == 0){
                    curMin = lastTriangle.get(0)+curTriangle.get(0);
                    curTriangle.set(0,curMin); 
                }else if(j == curTriangle.size()-1){
                    int result = lastTriangle.get(j-1)+curTriangle.get(j);
                    curTriangle.set(j,result); 
                }else{
                    int left = lastTriangle.get(j-1) + curTriangle.get(j);
                    int right = lastTriangle.get(j) + curTriangle.get(j);
                    int result = Math.min(left,right);
                    curTriangle.set(j,result);
                }
                if(curTriangle.get(j) < curMin) curMin = curTriangle.get(j);
            }
            min = curMin;
            lastTriangle = curTriangle;
        }
        return min;
    }
}