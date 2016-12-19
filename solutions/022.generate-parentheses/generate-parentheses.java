public class Solution {
    public class Triplet {
        String str;
        int oneCount = 1;
        //本来想用二进制表示字符串的 1表示左括号 0表示右括号
        int zeroCount = 0;
        Triplet(String s, int o,int z){
            str = s;
            oneCount = o;
            zeroCount = z;
        }
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new  ArrayList<String>();
        if(n == 0){
            result.add("");
            return result;
        }
        ArrayList<Triplet> temp = new ArrayList<Triplet>();
        temp.add(new Triplet("(",1,0));
        for(int i = 2; i <= 2*n;i++){
            ArrayList<Triplet> currentResult = new ArrayList<Triplet>();
            for(int j = 0;j < temp.size();j++){
                Triplet currentTri = temp.get(j);
                if(currentTri.oneCount > currentTri.zeroCount){
                    Triplet currentTriPlus0 = new Triplet(currentTri.str+")",currentTri.oneCount, currentTri.zeroCount+1);
                    currentResult.add(currentTriPlus0);
                }
                if(currentTri.oneCount < n){
                    Triplet currentTriPlus1 = new Triplet(currentTri.str+"(",currentTri.oneCount+1, currentTri.zeroCount);
                    currentResult.add(currentTriPlus1);
                }
            }
            temp = currentResult;
        }
        for(Triplet tri : temp){
            result.add(tri.str);
        }
        return result;
    }
}