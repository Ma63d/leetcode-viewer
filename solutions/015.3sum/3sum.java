import java.util.*;
public class Solution {
    // 超时了
    // public List<List<Integer>> threeSum(int[] nums) {
    //     List list = new ArrayList();
    //     if(nums.length < 3){
    //         return list;
    //     }
    //     Map map=new HashMap(nums.length*nums.length);
    //     for(int i = 1;i < nums.length;i++){
    //         int numI = nums[i];
    //         ArrayList arrOfNumI = (ArrayList)map.get(-numI);
    //         if(arrOfNumI != null){
    //             for(int k = 0;k < arrOfNumI.size(); k++){
    //                 ArrayList copy = (ArrayList)((ArrayList)arrOfNumI.get(k)).clone();
    //                 copy.add(numI);
    //                 list.add(copy);
    //             }
                    
    //         }
    //         for(int j = 0; j < i;j++){
    //             int numJ = nums[j];
    //             int result = numI + numJ;

    //             if(i != nums.length -1){
    //                 ArrayList arrOfResult = (ArrayList)map.get(result);
    //                 if(arrOfResult == null){
    //                     arrOfResult = new ArrayList();
    //                     ArrayList doublet = new ArrayList();
    //                     doublet.add(numI);
    //                     doublet.add(numJ);
    //                     arrOfResult.add(doublet);
    //                     map.put(result,arrOfResult);
    //                 }else{
    //                     ArrayList doublet = new ArrayList();
    //                     doublet.add(numI);
    //                     doublet.add(numJ);
    //                     arrOfResult.add(doublet);
    //                 }
    //             }
    //         }
    //     }
    //     HashSet resultSet = new HashSet();
    //     for(int i = 0;i < list.size();i++){
    //         List triplets = (List)list.get(i);
    //         Collections.sort(triplets);
    //         resultSet.add(triplets);
    //     }
    //     return new ArrayList(resultSet);
    // }
    public List<List<Integer>> threeSum(int[] nums) {
        List list = new ArrayList();
        if(nums.length < 3){
            return list;
        }
        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 2;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int sum = nums[i];
            int front = i+1;
            int end = nums.length -1;
            while(front < end){
                if(end < nums.length -1 && nums[end] == nums[end+1]){
                    end--;
                    continue;
                }
                if(front>i+1 && nums[front] == nums[front-1]){
                    front++;
                    continue;
                }
                if(nums[front] + nums[end] == -sum){
                    ArrayList triplet = new ArrayList();
                    triplet.add(sum);
                    triplet.add(nums[front]);
                    triplet.add(nums[end]);
                    list.add(triplet);
                    end--;
                    front++;
                }else if(nums[front] + nums[end] > -sum){
                    end--;
                }else{
                    front++;
                }
            }
        }
        return list;
    }
}