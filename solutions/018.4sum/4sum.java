public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List result = new ArrayList();
        if(nums.length < 4){
            return result;
        }
        Arrays.sort(nums);
        if(4 * nums[0] > target ||  4 * nums[nums.length - 1] < target){
            return result;
        }
        for(int i = 0; i < nums.length - 3;i++){
            int numI = nums[i];
            if(numI * 4 > target) return result;
            if(i > 0 && numI == nums[i-1]) continue;
            for(int j = i+1; j < nums.length - 2;j++){
                int numJ = nums[j];
                if(numJ * 3 > target - numI) break;
                if(j > i+1 && numJ == nums[j-1]) continue;
                int start = j+1,end = nums.length-1;
                int sumIJ = numI + numJ;
                if(2 * nums[start] > target - sumIJ){
                    break;
                }
                if(2 * nums[end] < target - sumIJ){
                    continue;
                }
                while(start < end){
                    if(end < nums.length-1 && nums[end] == nums[end+1]){
                        end--;continue;
                    }
                    if(start > j+1 && nums[start] == nums[start-1]){
                        start++;continue;
                    }
                    int sum = sumIJ + nums[start] + nums[end];
                    if(sum == target){
                        ArrayList quadralet = new ArrayList();
                        quadralet.add(numI);quadralet.add(numJ);quadralet.add(nums[start]);quadralet.add(nums[end]);
                        result.add(quadralet);
                        start++;end--;
                    }else if(sum > target){
                        end--;
                    }else{
                        start++;
                    }
                }
            }
        }
        return result;
    }
}