public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int len = Math.min(a.length(),b.length());
        int i;
        int upgrade = 0;
        for(i = 0;i < len;i++){
            int x = a.charAt(a.length()-i-1)-'0';
            int y = b.charAt(b.length()-i-1)-'0';
            int sum = x + y + upgrade;
            if(sum >= 2){
                upgrade = 1;
            }else{
                upgrade = 0;
            }
            result.insert(0,sum%2);
        }
        if(a.length() != b.length()){
            String toAdd;
            if(a.length() > b.length()){
                toAdd = a;
            }else{
                toAdd = b;
            }
            for(;i < toAdd.length();i++){
                int x = toAdd.charAt(toAdd.length()-i-1)-'0';
                int sum = x + upgrade;
                if(sum == 2){
                    upgrade = 1;
                }else{
                    upgrade = 0;
                }
                result.insert(0,sum%2);
            }
        }
        if(upgrade == 1){
            result.insert(0,1);
        }
        return result.toString();
    }
}