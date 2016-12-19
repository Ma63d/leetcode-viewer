public class Solution {
    public String intToRoman(int num) {
        String numStr = num + "";
        char[] numChars = numStr.toCharArray();
        String[] units = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] decades = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] thousands = {"","M","MM","MMM"};
        String result = "";
        for(int i = 0;i < numChars.length;i++){
            switch(numChars.length -1 -i){
                case 0:
                result +=  units[numChars[i]-'0'];
                break;
                case 1:
                result +=  decades[numChars[i]-'0'];
                break;
                case 2:
                result +=  hundreds[numChars[i]-'0'];
                break;
                case 3:
                result +=  thousands[numChars[i]-'0'];
                break;
                
            }
        }
        return result;
    }
}