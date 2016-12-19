public class Solution {
    public List<String> letterCombinations(String digits) {
        List result = new ArrayList();
        List lastResult = result;
        for(int i = 0;i < digits.length();i++){
            int num = digits.charAt(i) - '0';
            List charArr = new ArrayList();
            switch(num){
                case 2:
                    charArr.add("a");charArr.add("b");charArr.add("c");
                    break;
                case 3:
                    charArr.add("d");charArr.add("e");charArr.add("f");
                    break;
                case 4:
                    charArr.add("g");charArr.add("h");charArr.add("i");
                    break;
                case 5:
                    charArr.add("j");charArr.add("k");charArr.add("l");
                    break;
                case 6:
                    charArr.add("m");charArr.add("n");charArr.add("o");
                    break;
                case 7:
                    charArr.add("p");charArr.add("q");charArr.add("r");charArr.add("s");
                    break;
                case 8:
                    charArr.add("t");charArr.add("u");charArr.add("v");
                    break;
                case 9:
                    charArr.add("w");charArr.add("x");charArr.add("y");charArr.add("z");
                    break;
                default:
                    return new ArrayList();
            }
            if(i == 0){
                result.addAll(charArr);
            }else{
                lastResult = result;
                result = new ArrayList();
                for(int j = 0;j < lastResult.size();j++){
                    String curStr = (String)lastResult.get(j);
                    result.add(curStr + charArr.get(0));
                }
                for(int j= 0;j < lastResult.size();j++) {
                    String curStr = (String)lastResult.get(j);
                    for (int k = 1; k < charArr.size(); k++) {
                        result.add(curStr+charArr.get(k));
                    }
                }
            }
        }
        return result;
    }
}