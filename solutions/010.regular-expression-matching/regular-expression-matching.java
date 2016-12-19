public class Solution {
    public class Process {
        int regStart = 0;
        int regLen = 0;
        int matchStart = 0;
        int matchLen = 0;
        Process(int st,int len,int mst,int mlen){
            regStart = st;
            regLen = len;
            matchStart = mst;
            matchLen = mlen;
        }
    }
    public boolean isMatch(String s, String p){
        if(s.length() == 0 ){
            if(p.length() == 0){
                return true;
            }else if(p.length() == 1){
                return false;
            }
            
        }
        char[] arrS = s.toCharArray();
        char[] arrReg = p.toCharArray();
        Stack processes = new Stack();
        //这个processes栈用来记录匹配的过程,具体就是记录每个匹配单元匹配了arrS的哪一段;
        //匹配单元是指"x" "." "x*" ".*"这四种情况
        //因为匹配的过程中"x*",".*"这两种匹配单元的可能匹配0到n个字符串所以需要记录下来
        int regStart =0,matchStart=0,matchEnd = arrS.length - 1;
        while(!(regStart == arrReg.length && matchStart == arrS.length)){
            //总的思想就是匹配的时候先尽可能的往后匹配
            //同时每次匹配都记录下匹配的片段,生成一个process压到processes里面去了
            //如果后续匹配失败的话就调用popStack从processes找出某一个可减少匹配长度的process,而在找出之前遇到的不能减少匹配长度的process就从processes吐出来扔掉
            //然后减少这个可减少匹配长度的process的匹配长度,继续往后匹配
            //如此往复,直至processes栈里面没有可减少匹配长度的process 那就匹配失败了
            if(regStart == arrReg.length ){
                return false;
            }else if(matchStart == arrS.length){
                if(regStart+1 < arrReg.length && arrReg[regStart+1] == '*'){
                    processes.push(new Process(regStart,2,matchStart,0));
                    regStart += 2;
                }else{
                    Process changeablePrcs = popStack(processes);
                    if(changeablePrcs != null){
                        changeablePrcs.matchLen--;
                        regStart = changeablePrcs.regStart;
                        matchStart = changeablePrcs.matchStart;
                        matchEnd = changeablePrcs.matchLen-1+matchStart;
                    }else{
                        return false;
                    }
                }
            } else{
                if(isRightChar(arrReg[regStart])){
                    if(regStart+1 < arrReg.length && arrReg[regStart+1] == '*'){
                        char[] regUnit = {arrReg[regStart],arrReg[regStart+1]};
                        int matchResult = match(arrS,regUnit,matchStart,matchEnd);
                        processes.push(new Process(regStart,2,matchStart,matchResult));
                        regStart += 2;
                        matchStart += matchResult;
                        matchEnd = arrS.length - 1;
                    }else{
                        char[] regUnit = {arrReg[regStart]};
                        int matchResult = match(arrS,regUnit,matchStart,matchEnd);
                        if(matchResult > 0){
                            processes.push(new Process(regStart,1,matchStart,matchResult));
                            regStart++;
                            matchStart += matchResult;
                        }else{
                            Process changeablePrcs = popStack(processes);
                            if(changeablePrcs != null){
                                changeablePrcs.matchLen--;
                                regStart = changeablePrcs.regStart;
                                matchStart = changeablePrcs.matchStart;
                                matchEnd = changeablePrcs.matchLen-1+matchStart;
                            }else{
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean isRightChar(char a){
        if((a >= 65 && a <= 90) || (a >= 97 && a <= 122) || a == '.'){
            return true;
        }
        return false;
    }
    public int match(char[] arrS,char[] arrReg,int start,int end){
        //用于查询arrS从start到end位置(闭区间)是否有能被arrReg匹配上的字符串
        //char[] arrReg是因为有的时候要匹配'a*','.*'这样的
        //返回被匹配的长度,
        if(end < start){
            return 0;
        }
        if(arrReg.length == 1){
            if(arrReg[0] == '.'){
                return (arrS[start] >= 65 && arrS[start] <= 90) || (arrS[start] >= 97 && arrS[start] <= 122)? 1:0;
            }else{
                return arrS[start] == arrReg[0] ? 1:0;
            }
        }else{
            int len = 0;
            if(arrReg[0] == '.'){
                for(;start <= end;start++){
                    if((arrS[start] >= 65 && arrS[start] <= 90) || (arrS[start] >= 97 && arrS[start] <= 122)){
                        len++;
                        continue;
                    }
                    break;
                }
            }else{
                for(;start <= end;start++){
                    if(arrS[start] == arrReg[0]){
                        len++;
                        continue;
                    }
                    break;
                }
            }
            return len;
        }
    }
    public Process popStack(Stack processes){
        //这个函数用于从processes栈里面找出某一个可减少匹配长度的process
        //什么意思? 意思是某一个正则匹配单元比如".*"
        //假如在之前匹配的时候它匹配的是"abcd",然后导致了后面的匹配失败了
        //现在我可以让他只匹配"abc",然后看看后面的匹配能不能成功
        Process prcs = null;
        while(!processes.empty()){
            Process curPrcs = (Process)processes.pop();
            if(curPrcs.regLen == 2 && curPrcs.matchLen != 0){
                prcs = curPrcs;
                break;
            }
        }
        return prcs;
    }
}