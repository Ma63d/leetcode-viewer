public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1]){
            return false;
        }
        int left = 0,right = matrix.length-1;
        while(left < right){
            int middle = (left+ right)/2;
            if(matrix[middle][0] > target){
                right = middle-1;
            }else{
                if(left != middle){
                    left = middle;    
                }else{
                    if(matrix[right][0] <= target)
                        left = right;
                    break;   
                }
            }
        }
        if(matrix[left][matrix[0].length-1] < target){
            return false;
        }else{
            for(int j = 0;j< matrix[0].length;j++){
                if(matrix[left][j] == target){
                    return true;
                }
            }
            return false;
        }
    }
}