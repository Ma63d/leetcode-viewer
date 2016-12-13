public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0 ; i< nums.length;i++){
            if(map.get(nums[i]) != null){
                result[0]= map.get(nums[i]);
                result[1] = i;
                break;
            }else{
                map.put(target-nums[i],i);
            }
        }
        return result;
    }
}