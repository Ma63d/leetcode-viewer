public class Solution {
    public int longestValidParentheses(String s) {
        int[] nums = new int[s.length()];
        //把括号字符串转换为-1,+1的数组
        int count = 0,total = 0,max = 0,start =0;
        for(int i = 0;i < s.length();i++){
            nums[i] = s.charAt(i) == '('? 1:-1;
            total = total + nums[i];
            if(total < 0){
                total = 0;
                count = 0;
                start = i+1;
                continue;
            }
            count++;
            if(total == 0 && count > max){
                max = count;
            }
        }
        if(total > 0 && (nums.length - start) > max){
            count = 0;total = 0;
            for(int j = nums.length-1;j >= start;j--){
                total = total + nums[j];
                if(total > 0){
                    total = 0;
                    count = 0;
                    continue;
                }
                count++;
                if(total == 0 && count > max){
                    max = count;
                }
            }
        } 
        return max;
    }
}