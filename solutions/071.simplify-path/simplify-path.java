public class Solution {
    public String simplifyPath(String path) {
        Stack<String> result = new Stack<String>();
        String[] str = path.split("/");
        for(int i = 0;i < str.length;i++){
            switch(str[i]){
                case "":break;
                case ".":break;
                case "..":if(!result.empty()){
                    result.pop();
                }
                break;
                default: result.push(str[i]);
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(result.empty()){
            return "/";
        }
        while(!result.empty()){
            sb.insert(0,"/"+result.pop());
        }
        return sb.toString();
    }
}