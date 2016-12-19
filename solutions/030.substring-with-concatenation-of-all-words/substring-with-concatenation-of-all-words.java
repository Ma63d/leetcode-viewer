public class Solution {
    class Node {
        int position;
        int count;
        Node(int p,int c){
            position = p;
            count = c;
        }
    }
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap map = new HashMap();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int len = words[0].length();
        for(int i = 0; i < words.length;i++){
            if(map.get(words[i]) == null){
                Node newNode = new Node(i,1);
                map.put(words[i],newNode);
            }else{
                Node oldNode = (Node)map.get(words[i]);
                oldNode.count++;
            }
        }
        int[] leftMatchedOfPos = new int[words.length];
        //记录words中该位置还可以match几次
        for(int j = 0; j + len*words.length <= s.length(); j++){
            Arrays.fill( leftMatchedOfPos, -1);
            int i = j;
            int countMatched = 0;
            outLoop:while(countMatched < words.length){
                String current = s.substring(i,i+len);
                if(map.get(current) == null){
                    break;
                }
                Node posAndCount = (Node)map.get(current);
                switch(leftMatchedOfPos[posAndCount.position]){
                    case -1:
                        leftMatchedOfPos[posAndCount.position] = posAndCount.count - 1;
                        break;
                    case 0:
                        break outLoop;
                    default:
                        leftMatchedOfPos[posAndCount.position]--;
                        break;
                }
                countMatched++;
                i+= len;
            }
            if(countMatched == words.length){
                result.add(j);
            }
        }
        return result;
    }
}    