public class Solution {
    //靠 题目读错了
    //以为是判断是否s3是由s2整体插入到s1中构成
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
    	int len2 = s2.length();
    	int len3 = s3.length();
    	if(len1 + len2 != len3){
    		return false;
    	}
    	boolean[][] f = new boolean[len1+1][len2+1];
    	f[0][0] = true;
    	for(int i = 0; i < len1+1;i++){
    		for(int j = 0; j < len2+1; j++){
    			if(j > 0){
    				f[i][j] = f[i][j-1]&&(s3.charAt(i+j-1) == s2.charAt(j-1));
    			}
    			if(i > 0){
    				f[i][j] = f[i][j] || ( f[i-1][j]&&(s3.charAt(i+j-1) == s1.charAt(i-1)));
    			}
    		}
    	}
    	return f[len1][len2];
    }
    
}