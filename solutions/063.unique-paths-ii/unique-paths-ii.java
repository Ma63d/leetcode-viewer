public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int xLen = obstacleGrid.length;
        int yLen = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1){
                return 0;
        }
        if(xLen == 1 && yLen == 1){
            return 1;
        }
        obstacleGrid[0][0] = -1;
        for(int i = 1;i <= xLen-1+yLen-1;i++){
            int y = Math.min(i,yLen-1);
            int x = i - y;
            for(;y > -1 && x < xLen;y--,x++){
                if(obstacleGrid[x][y] == 1){
                    continue;
                }
                if(x-1 >=0){
                    if(obstacleGrid[x-1][y] != 1){
                        obstacleGrid[x][y] += obstacleGrid[x-1][y];
                    }
                }
                if(y-1 >= 0){
                    if(obstacleGrid[x][y-1] != 1){
                        obstacleGrid[x][y] += obstacleGrid[x][y-1];
                    }
                }
            }
        }
        if(obstacleGrid[xLen-1][yLen-1] == 1){
            return 0;
        }else{
            return -obstacleGrid[xLen-1][yLen-1];
        }
    }
}