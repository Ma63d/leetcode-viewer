public class Solution {
    //这种对父结构、子结构、子子结构...都进行了变换的情况,很明显,需要递归的进行处理;
    //以后要形成这种明显的思维定势
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){
             return false;
        }else{
            if(s1.equals(s2)){
                return true;
            }else if(s1.length() ==1){
                return false;
            }
            int[] map = new int[58];
            for(int i = 0;i < s1.length();i++){
                char cur = s1.charAt(i);
                map[cur-'A']++;
            }
            for(int i = 0;i < s2.length();i++){
                char cur = s2.charAt(i);
                if(--map[cur-'A'] < 0){
                    return false;
                }
            }
            for(int i = 1;i < s1.length();i++){
                if(isScramble(s1.substring(0,i),s2.substring(0,i))){
                    if(isScramble(s1.substring(i),s2.substring(i))){
                        return true;
                    }
                }else if(isScramble(s1.substring(0,i),s2.substring(s2.length()-i))){
                    if(isScramble(s1.substring(i),s2.substring(0,s2.length()-i))){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}