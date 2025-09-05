class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int k = 0; k <= 60; k++){
            long x = (long)num1 - (long)k * num2;
            if(x < 0){
                continue;
            }

            int popCount = Long.bitCount(x);
            if(popCount <= k && k <= x){
                return k;
            }
        }

        return -1;
    }
}