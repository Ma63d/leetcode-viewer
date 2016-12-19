public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int closest = nums[0]+nums[1]+nums[2];
        int distance = Math.abs(target - closest);
        for(int i = 0;i < nums.length - 2;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int numsI = nums[i];
            int front = i+1;
            int end = nums.length -1;
            while(front < end){
                if(end < nums.length -1 && nums[end] == nums[end+1]){
                    end--;
                    continue;
                }
                if(front>i+1 && nums[front] == nums[front-1]){
                    front++;
                    continue;
                }
                int cur = nums[front] + nums[end] + numsI;
                if(cur == target){
                    return target;
                }else if(cur > target){
                    end--;
                }else{
                    front++;
                }
                int distanceCur = Math.abs(target-cur);
                if(distanceCur < distance){
                    closest = cur;
                    distance = distanceCur;
                }
            }
        }
        return closest;
    }
}