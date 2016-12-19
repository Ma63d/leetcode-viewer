public class Solution {
    public int areaOfHistogram (int[] heights){
        Stack<Integer> st = new Stack<Integer>();
        int[] h = Arrays.copyOf(heights,heights.length+1);
        int max = 0;
        for(int i = 0;i < h.length;i++){
            if(st.empty() || h[i] >= h[st.peek()]){
                st.push(i);
            }else{
                while(!st.empty() && h[i] < h[st.peek()]){
                    int top = st.pop();
                    int left = st.empty()?-1:st.peek();
                    int area = h[top] * (i -1 - left);
                    if(area > max){
                        max = area;
                    }
                }
                st.push(i);
            }
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int max = 0;
        int[] h = new int[matrix[0].length];
        for(int i = 0; i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    h[j]++;
                }else{
                    h[j] = 0;
                }
            }
            int area = areaOfHistogram(h);
            if(area > max){
                max = area;
            }
        }
        return max;
    }
}