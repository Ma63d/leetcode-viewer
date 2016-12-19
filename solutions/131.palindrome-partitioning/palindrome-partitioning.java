public class Solution {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>>result = new ArrayList<List<String>>();
        if(s.length() == 0) return result;
        //return _formResult(s,0,s.length()-1,formMatrix(s));
        formResult(s,0,formMatrix(s),new ArrayList<String>(),result);
        return result;
    }
    public void formResult(String s,int start,int[][] matrix,List<String> current,List<List<String>> result){
        if(start == s.length()){
            result.add(new ArrayList<String>(current));
        }else{
            for(int i = s.length()-1;i >= start ;i--){
                if(matrix[start][i] == 1){
                    current.add(s.substring(start,i+1));
                    formResult(s,i+1,matrix,current,result);
                    current.remove(current.size()-1);
                }
            }
        }
    }
    public int[][] formMatrix(String s){
        int[][] result = new int[s.length()][];
        for(int i = 0; i < s.length();i++){
            result[i] = new int[s.length()];
            result[i][i] = 1;
            for(int j = i-1;j > -1;j--){
                if(j == i - 1){
                    if(s.charAt(j) == s.charAt(i)) result[j][i] =1;
                }else{
                    if(result[j+1][i-1] ==1){
                        if(s.charAt(j) == s.charAt(i)) result[j][i] =1;
                    }
                }
            }
        }
        return result;
    }
    //写得太复杂啦 很多的代码可以在递归的环节省略掉
    //重构一下
    // public List<List<String>> _formResult(String s,int start,int end,int[][] matrix){
    //     ArrayList<List<String>> result = new ArrayList<List<String>>();
    //     if(start > end){
    //         result.add(new ArrayList<>());
    //     }else if(start == end){
    //         ArrayList<String> cur = new ArrayList<String>();
    //         cur.add(s.charAt(start)+"");
    //         result.add(cur);
    //     }else{
    //         for(int i = start; i <= end ;i++){
    //             ArrayList<String> front = new ArrayList<String>();
    //             for(int k = start;k < i;k++){
    //                 front.add(s.charAt(k)+"");
    //             }
    //             if(i == end){
    //                 front.add(s.substring(end));
    //                 result.add(front);
    //             }
    //             for(int j = end; j > i;j--){
    //                 if(matrix[i][j] == 1){
    //                     ArrayList<String> cur = new ArrayList<>(front);
    //                     cur.add(s.substring(i,j+1));
    //                     List<List<String>> next = formResult(s,j+1,end,matrix);
    //                     for(List<String> ls : next){
    //                         ArrayList<String> cl = new ArrayList<>(cur);
    //                         cl.addAll(ls);
    //                         result.add(cl);
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return result;
    // }
}