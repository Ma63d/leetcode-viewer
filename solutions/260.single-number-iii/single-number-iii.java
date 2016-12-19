public class Solution {
    public int[] singleNumber(int[] nums) {
        //自己实在是想不出来
        //看了别人的答案,OOOOOhhhh MY GOOOOD
        
        // 首先计算nums数组中所有数字的异或，记为xor

        // 令lowbit = xor & -xor，lowbit的含义为xor从低位向高位，第一个非0位所对应的数字
        
        // 例如假设xor = 6（二进制：0110），则-xor为（二进制：1010，-6的补码，two's complement）
        
        // 则lowbit = 2（二进制：0010）
        
        // 根据异或运算的性质，“同0异1” (所以 a b两个数字在这一位一定不相同!!! 这思路给跪了!)
        
        // 记只出现一次的两个数字分别为a与b
        
        // 可知a & lowbit与b & lowbit的结果一定不同
        
        // 通过这种方式，即可将a与b拆分开来
        
        int[] res = new int[2];  
        int result = nums[0];  
        for(int i=1;i<nums.length;i++){  
            result ^= nums[i];  
        }  
        res[0] = 0;  
        res[1] = 0;  
        int n = result & (~(result-1));  
        for(int i=0;i<nums.length;i++){  
            if((n & nums[i])!=0){  
                res[0] = res[0] ^ nums[i];  
            }else {  
                res[1] = res[1] ^ nums[i];  
            }  
        }  
        return res;
    }
}