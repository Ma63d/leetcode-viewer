public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int start = 0,alreadyLen = words[0].length();
        for(int i = 0;i < words.length;i++){
            if(i+1 < words.length){
                if(alreadyLen+words[i+1].length() + 1 > maxWidth){
                    result.add(justify(words,start,i,alreadyLen,maxWidth));
                    start = i+1;
                    alreadyLen = words[i+1].length();
                }else{
                    alreadyLen += words[i+1].length() + 1;
                }
            }else{
                result.add(justify(words,start,i,alreadyLen,maxWidth));
            }
        }
        return result;
    }
    public String justify(String[] words, int start,int i ,int alreadyLen,int maxWidth){
        if(start == i){
            while(alreadyLen < maxWidth){
                    words[start] += ' ';
                    alreadyLen++;
            }
            return words[start];
        }else{
            StringBuilder sb = new StringBuilder();
            if(i == words.length-1){
                sb.append(words[start]);
                while(start+1 <= i){
                    sb.append(' ');
                    sb.append(words[++start]);
                }
                while(alreadyLen < maxWidth){
                    sb.append(' ');
                    alreadyLen++;
                }
            }else{
                int len = i - start;
                int pad = (maxWidth-alreadyLen)/len;
                int left = (maxWidth-alreadyLen) - pad*len;
                sb.append(words[start]);
                while(start+1 <= i){
                    StringBuilder append = new StringBuilder();
                    for(int j = 0;j < pad;j++){
                        append.append(' ');
                    }
                    sb.append(append);
                    if(left > 0){
                        sb.append(' ');
                        left--;
                    }
                    sb.append(' ');
                    sb.append(words[++start]);
                }
            }
            return sb.toString();
        }
    }
}