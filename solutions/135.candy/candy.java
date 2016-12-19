public class Solution {
    public int candy(int[] ratings) {
        // if(ratings == null) return 0;
        // if(ratings.length < 2) return ratings.length;
        // int[] result = new int[ratings.length];
        // Stack<Integer> st = new Stack<>();
        // st.push(ratings[0]);
        // result[0] = 1;
        // for(int i =1;i < ratings.length;i++){
        //     if(ratings[i] >= st.peek()){
        //         int j = 1;
        //         while(!st.isEmpty()){
        //             st.pop();
        //             if(j > result[i-j]) result[i-j] = j;
        //             j++;
        //         }
        //         st.push(ratings[i]);
        //         result[i] = (ratings[i] == ratings[i-1])?1:result[i-1]+1;
        //     }else{
        //         st.push(ratings[i]);
        //         if(i == ratings.length -1){
        //             int j = 1;
        //             while(!st.isEmpty()){
        //                 st.pop();
        //                 if(j > result[i+1-j]) result[i+1-j] = j;
        //                 j++;
        //             }
        //         }
        //     }
        // }
        if(ratings == null) return 0;
        if(ratings.length < 2) return ratings.length;
        int[] result = new int[ratings.length];
        for(int i = 0;i< ratings.length;i++){
            if(i == ratings.length-1 || ratings[i] <= ratings[i+1]){
                if(i == 0){
                    result[i] = 1;    
                }else if(ratings[i] <= ratings[i-1]){
                    result[i] = 1;    
                    int j = i;
                    while(j > 0 && ratings[j] < ratings[j-1]){
                        result[j-1] = Math.max(result[j]+1,result[j-1]);
                        j--;
                    }
                }else{
                    result[i] = result[i-1]+1;
                }
            }else if(i > 0 && ratings[i] > ratings[i-1]){
                result[i] = result[i-1]+1;
            }
        }
        int totalCount = 0;
        for(int cur : result){
            totalCount += cur;
        }
        return totalCount;
    }
}