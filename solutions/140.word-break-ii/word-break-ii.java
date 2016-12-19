public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> curResult = new ArrayList<>();
        _solve(s,0,new HashSet<>(),wordDict,curResult,result);
        return result;
    }
    public boolean _solve(String s,int start,Set<Integer> fail,Set<String> wordDict,List<String> curResult,List<String> result){
        if(start == s.length()) {
            StringBuilder sb = new StringBuilder();
            for(String cur :curResult){
                sb.append(cur+" ");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return true;
        }
        boolean everSolved = false;
        for(int i = start+1; i <= s.length();i++){
            if(!fail.contains(i)){
                if(wordDict.contains(s.substring(start,i))){
                    curResult.add(s.substring(start,i));
                    if(_solve(s,i,fail,wordDict,curResult,result)){
                        everSolved = true;
                    };
                    curResult.remove(curResult.size()-1);
                }
            }
        }   
        if(!everSolved){
            fail.add(start);
            return false;
        }
        return true;
    }
}