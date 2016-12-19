public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        return _solve(s,0,new HashSet<>(),wordDict);
    }
    public boolean _solve(String s,int start,Set<Integer> fail,Set<String> wordDict){
        if(start == s.length()) return true;
        for(int i = start+1; i <= s.length();i++){
            if(!fail.contains(i)){
                if(wordDict.contains(s.substring(start,i))){
                    if(_solve(s,i,fail,wordDict)){
                        return true;
                    }
                }
            }
        }   
        fail.add(start);
        return false;
    }
}