public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> need =  new HashMap<Character,Integer>();
        HashMap<Character,Integer> extra =  new HashMap<Character,Integer>();
        for(int i = 0;i < t.length();i++){
            if(need.get(t.charAt(i)) == null){
                need.put(t.charAt(i),1);
            }else{
                need.put(t.charAt(i),need.get(t.charAt(i))+1);
            }
        }
        int start = 0,end = start,maxLen = s.length()+1;
        String result = "";
        while(end < s.length() && start < s.length()){
            while(!need.isEmpty()){
                if(end < s.length()){
                    char endChar = s.charAt(end);
                    if(need.get(endChar) ==null){
                        if(extra.get(endChar) == null){
                            extra.put(endChar,1);
                        }else{
                            extra.put(endChar,extra.get(endChar)+1);
                        }
                    }else{
                        int numsToFix = need.get(endChar);
                        if(numsToFix == 1){
                            need.remove(endChar);
                        }else{
                            need.put(endChar,numsToFix-1);
                        }
                    }
                    end++;
                }else{
                    return result;
                }
            }
            char startChar = s.charAt(start);
            while(extra.get(startChar) != null){
                int extraLeft = extra.get(startChar);
                if(extraLeft == 1){
                    extra.remove(startChar);
                }else{
                    extra.put(startChar,extraLeft-1);
                }
                start++;
                startChar = s.charAt(start);
            }
            if(end - start < maxLen){
                maxLen = end - start +1;
                result = s.substring(start,end);
            }
            if(end < s.length() && start < s.length()){
                need.put(startChar,1);
                start++;
            }
        }
        return result;
    }
}