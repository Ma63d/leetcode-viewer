public class Solution {
    ArrayList<Integer>  result = new ArrayList<Integer>();
    public List<Integer> grayCode(int n) {
        this.result = new ArrayList<Integer>();
        this.result.add(0);
        int[] used = new int[1 << n];
        used[0] = 1;
        generate(1 << n,0,1,used,this.result);
        return this.result;
    }
    public boolean generate(int n,int last,int m,int[] used,ArrayList<Integer> alreadyAdd){
        if(n == m){
            return true;
        }
        for(int i = 0;i < n;i++){
            int bitAtI = (last >> i) % 2;
            int adder = ((bitAtI == 0)?1:-1)*(1 << i);
            if(used[last+adder] == 0){
                alreadyAdd.add(last+adder);
                used[last+adder] = 1;
                if(generate(n,last+adder,m+1,used,alreadyAdd)){
                    return true;
                }
                used[last+adder] = 0;
                alreadyAdd.remove(alreadyAdd.size()-1);
            }
        }
        return false;
    }
    
}