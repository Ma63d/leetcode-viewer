public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0;i < 32;i++){
            int cur = 1 << i;
            int count = 0;
            for(int j = 0; j < nums.length;j++){
                if((cur & nums[j]) != 0){
                    count++;
                }
            }
            if(count % 3 == 1){
                result |= cur;
            }
        }
        return result;
    } 
}