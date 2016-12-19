public class Solution {
    // public int largestRectangleArea(int[] heights) {
    //     if(heights==null || heights.length<1){
    //         return 0;
    //     }
    //     int[][] rmq = rmq(heights);
    //     int max = 0;
    //     for(int i = 0;i < heights.length;i++){
    //         for(int j = i;j< heights.length;j++){
    //             int min = (j-i+1)*rmqSolve(rmq,i,j);
    //             if(min > max){
    //                 max = min;
    //             }
    //         }
    //     }
    //     return max;
    // }
    // public int[][] rmq(int[] heights){
    //     int times = (int)(Math.log(heights.length)/Math.log(2));
    //     int[][] result = new int[times+1][];
    //     int pow = 1;
    //     for(int i = 0;i < times+1;i++){
    //         result[i] = new int[heights.length+1-pow];
    //         for(int j = 0; j< heights.length+1-pow;j++){
    //             if(i == 0){
    //                 result[0][j] = heights[j];
    //             }else{
    //                 result[i][j] = Math.min(result[i-1][j],result[i-1][j+pow/2]);
    //             }
    //         }
    //         pow *= 2;
    //     }
    //     return result;
    // }
    // public int rmqSolve(int[][] rmqMatrix,int start,int end){
    //     int len = end - start +1;
    //     int pow = (int)(Math.log(len)/Math.log(2));
    //     return Math.min(rmqMatrix[pow][start],rmqMatrix[pow][end-(1 << pow)+1]);
    // }
    
    
    //单调栈的解法
    private class Node{
        int pos;
        int height;
        Node(int h,int p){
            pos = p;
            height = h;
        }
    }
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length<1){
            return 0;
        }
        Stack<Node> st = new Stack<Node>();
        st.push(new Node(0,-1));
        int max = 0;
        for(int i = 0;i < heights.length;i++){
            if(heights[i] < st.peek().height){
                while(st.size()>1 && st.peek().height > heights[i]){
                    Node top = st.pop();
                    int area = top.height * (i-1-st.peek().pos);
                    if(area>max){
                        max = area;
                    }
                }
            }
            st.push(new Node(heights[i],i));
        }
        if(st.size() > 1){
            int most = st.peek().pos;
            while(st.size() > 1){
                Node top =  st.pop();
                int area = top.height * (most - st.peek().pos);
                if(area>max){
                    max = area;
                }
            }
        }
        return max;
    }
}