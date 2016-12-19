public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x< 10){
            return true;
        }
        int length = 2;double oneWith0 = 100;
        while(x >= oneWith0){
            oneWith0 *= 10;
            length++;
        }
        oneWith0 /= 10;
        double startMod = 1;
        for(int i = 1;i <= length/2;i++){
            double endMod = oneWith0 / startMod;
            int numStart = (int)((x % (10*startMod)) / startMod);
            int numEnd = (int)((x % (10*endMod)) / endMod);
            if(numStart != numEnd){
                return false;
            }
            startMod *= 10;
        }
        return true;

    }
}