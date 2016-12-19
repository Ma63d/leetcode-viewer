public class Solution {
    public String reverseWords(String s) {
        System.out.println(s);
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            if(word.trim().length() == 0) continue;
            sb.insert(0,word+" ");
        }
        return sb.toString().trim();
    }
}