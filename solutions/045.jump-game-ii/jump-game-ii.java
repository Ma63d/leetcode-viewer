public class Solution {
    public int jump(int[] nums) {
        int start = 0,end = 0;
        int step = 0;
        while(end < nums.length -1){
            int max = 0;
            for(int i = start;i <= end;i++){
                if((i + nums[i])> max){
                    max = i + nums[i];
                }
            }
            start = end + 1;
            end = max;
            step++;
        }
        return step;
    }
}