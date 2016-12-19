public class Solution {
    public int trap(int[] height) {
        if(height.length < 3){
            return 0;
        }
        int leftEdge = 0,left = 0,maxRightEdge=0;
        boolean leftFound = false,bottomFound = false;
        int area = 0;
        int[][] rmq = new int[1][1];
        if(height.length > 3){
            rmq = rmq(height);
        }
        for(int i = 0;i < height.length;i++){
            if(!leftFound){
                if(height[i] >=leftEdge){
                    left = i;
                    leftEdge = height[i];
                }else{
                    leftFound = true;
                }
            }
            if(leftFound){
                if(!bottomFound){
                    if(height[i] > height[i-1]){
                        bottomFound = true;
                    }
                }
                if(bottomFound){
                    if(i == height.length-1){
                        area += solveArea(height,left,i);
                    }else if(height[i+1] < height[i] ){
                        if(height[i] < leftEdge && findMaxWithRmq(rmq,i+1,height.length-1) > height[i]){
                            bottomFound = false;
                        }else{
                            area += solveArea(height,left,i);
                            left = i;
                            leftEdge = height[i];
                            bottomFound = false;
                        }
                    }
                }
            }
        }
        return area;
    }
    private int[][] rmq(int[] height){
        int logLen = (int)(Math.log(height.length)/Math.log(2));
        int[][] result = new int[logLen+1][height.length];
        for(int i = 0;i < height.length;i++){
            result[0][i] = height[i];
        }
        for(int j = 1;j <= logLen;j++){
            for(int i = 0; i + (1 << j) - 1< height.length;i++){
                result[j][i] = Math.max(result[j-1][i],result[j-1][i+(1<<j-1)]);
            }
        }
        return result;
    }
    private int findMaxWithRmq(int[][]rmq,int start,int end){
        int len = end - start + 1;
        int logLen = (int)(Math.log(len)/Math.log(2));
        return Math.max(rmq[logLen][start],rmq[logLen][end - (1 << logLen)+1]);
    }
    private int solveArea(int[] height,int start,int end){
        int max = height[start] > height[end]?height[end]:height[start];
        int area = 0;
        for(int i = start+1;i < end;i++){
            area += Math.max(max - height[i],0);
        }
        return area;
    }
}