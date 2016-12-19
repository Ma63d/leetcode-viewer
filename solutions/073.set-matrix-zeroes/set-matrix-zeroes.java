public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean hen = false,zong = false;
        for(int i = 1;i< matrix.length;i++){
            if(matrix[i][0] == 0){
                zong = true;break;
            }
        }
        for(int j = 1;j< matrix[0].length;j++){
            if(matrix[0][j] == 0){
                hen = true;break;
            }
        }
        for(int i = 1;i < matrix.length;i++){
            for(int j = 1;j < matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int j = 1;j < matrix[0].length;j++){
            if(matrix[0][j] == 0){
                for(int i = 1;i < matrix.length;i++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 0;i < matrix.length;i++){
            if(matrix[i][0] == 0){
                for(int j = 1;j < matrix[0].length;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for(int i = 1;i < matrix.length;i++){
                matrix[i][0] = 0;
            }
            for(int j = 1;j < matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }else{
            if(hen){
                for(int j = 0;j < matrix[0].length;j++){
                    matrix[0][j] = 0;
                }
            }
            if(zong){
                for(int i = 0;i < matrix.length;i++){
                    matrix[i][0] = 0;
                }
            }
        }
    }
}