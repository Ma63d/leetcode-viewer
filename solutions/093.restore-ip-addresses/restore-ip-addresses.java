public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0) return res;
        dfs(res, s, 0, "");
        return res;
    }
    //自己写的比较乱 考虑的edge case太多
    //参考了网上的一份代码
    public void dfs(List<String> res, String s, int m, String tempS) {
        if (s.length() == 0) {
            if (m == 4) {
                res.add(tempS.substring(1));
                return;
            }
        } else {
            // 1 digit
            if (s.length() - 1 >= 4 - m - 1 && s.length() - 1 <= (4 - m - 1) * 3) {
                dfs(res, s.substring(1), m + 1, tempS + "." + s.substring(0,1)); 
            }
            // 2 digits
            if (s.length() >= 2 && s.length() - 2 >= 4 - m - 1 && s.length() - 2 <= (4 - m - 1) * 3) {
                if (Integer.valueOf(s.substring(0,2)) >= 10) {
                    dfs(res, s.substring(2), m + 1, tempS + "." + s.substring(0,2));
                }
            }
            // 3 digits
            if (s.length() >= 3 && s.length() - 3 >= 4 - m - 1 && s.length() - 3 <= (4 - m - 1) * 3) {
                if (Integer.valueOf(s.substring(0,3)) >= 100 && Integer.valueOf(s.substring(0,3)) <= 255) {
                    dfs(res, s.substring(3), m + 1, tempS + "." + s.substring(0,3));
                }
            }
        }
    }
}