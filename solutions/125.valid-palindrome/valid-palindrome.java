public class Solution {
    public boolean isPalindrome(String s) {
        //自己写的很low 看了一下 Character竟然有isLetterOrDigit这样一个方法.
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; ) {
            if (!Character.isLetterOrDigit(c[i])) i++;
            else if (!Character.isLetterOrDigit(c[j])) j--;
            else if (Character.toLowerCase(c[i++]) != Character.toLowerCase(c[j--])) 
                return false;
        }
        return true;
    }
}