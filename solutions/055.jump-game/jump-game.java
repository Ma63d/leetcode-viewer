public class Solution {
    public boolean canJump(int[] nums) {
        int lastStop = -1,maxStep = 0;
        while(maxStep < nums.length-1){
            if(maxStep == lastStop) return false;
            int start = lastStop+1;
            lastStop = maxStep;
            for(int i = start;i <= lastStop;i++){
                if(i + nums[i] > maxStep){
                    maxStep = i + nums[i];
                }
            }
        }
        return true;
    }
}