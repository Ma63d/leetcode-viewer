public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, sum = 0, start = 0;
        for (int i = 0; i < gas.length; ++i){
            total += (gas[i] - cost[i]);
            if (sum < 0){ //发现油箱空了，从下一个站点尝试
                sum = (gas[i] - cost[i]);
                start = i;
            }
            else
                sum += (gas[i] - cost[i]);
        }
        return total < 0 ? -1 : start;
    }
}