public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for(int i = 0;i < chars.length;i++){
            switch(chars[i]){
                case 'M':
                    result += 1000;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'C':
                    if(i+1 < chars.length){
                        if(chars[i+1] == 'D'){
                            result += 400;
                            i++;
                        }else if(chars[i+1] == 'M'){
                            result += 900;
                            i++;
                        }else{
                            result += 100;
                        }
                    }else{
                        result += 100;
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'X':
                    if(i+1 < chars.length){
                        if(chars[i+1] == 'L'){
                            result += 40;
                            i++;
                        }else if(chars[i+1] == 'C'){
                            result += 90;
                            i++;
                        }else{
                            result += 10;
                        }
                    }else{
                        result += 10;
                    }
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'I':
                    if(i+1 < chars.length){
                        if(chars[i+1] == 'V'){
                            result += 4;
                            i++;
                        }else if(chars[i+1] == 'X'){
                            result += 9;
                            i++;
                        }else{
                            result += 1;
                        }
                    }else{
                        result += 1;
                    }
                    break;
            }
        }
        return result;
    }
}