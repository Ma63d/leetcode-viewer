public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token: tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int right = st.pop();
                int left = st.pop();
                int result = 0;
                if(token.equals("+")){
                    result = left + right;
                }else if(token.equals("-")){
                    result = left - right;
                }else if(token.equals("*")){
                    result = left * right;
                }else if(token.equals("/")){
                    result = left / right;
                }
                st.push(result);
            }else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}