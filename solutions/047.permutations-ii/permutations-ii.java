public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> alreadyAdd = new ArrayList<Integer>();
        List<Integer> left = new ArrayList<Integer>();
        for(int i = 0;i < nums.length;i++){
            left.add(nums[i]);
        }
        addNums(alreadyAdd,left);
        return this.result;
    }
    public void addNums(List<Integer> alreadyAdd,List<Integer> left){
        if(left.isEmpty()){
            List<Integer> newResult = new ArrayList<Integer>(alreadyAdd);
            this.result.add(newResult);
        }else{
            for(int i = 0;i < left.size();i++){
                if(i > 0 && left.get(i) == left.get(i-1)) continue;
                int k = (int)left.remove(i);
                alreadyAdd.add(k);
                addNums(alreadyAdd,left);
                alreadyAdd.remove(alreadyAdd.size()-1);
                left.add(i,k);
            }
        }
    }
}