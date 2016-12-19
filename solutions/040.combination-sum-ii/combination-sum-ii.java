public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    HashSet x = new HashSet();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,target,new ArrayList<Integer>());
        Iterator it = this.x.iterator();
        while(it.hasNext()){
            this.result.add((List)(it.next()));
        }
        return this.result;
    }
    public void dfs(int[] candidates,int start,int target,List<Integer> lastResult){
        if(target == 0){
            List<Integer> curResult = new ArrayList<Integer>(lastResult);
            x.add(curResult);
        }else{
            for(int i = start; i < candidates.length;i++){
                if(target >= candidates[i]){
                    lastResult.add(candidates[i]);
                    dfs(candidates,i+1,target - candidates[i],lastResult);
                    lastResult.remove(lastResult.size()-1);
                }else{
                    break;
                }
            }
        }
    }
}