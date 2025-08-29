class Solution {
    public int longestString(int x, int y, int z) {
        int result = 2*z + Math.min(x,y) * 4;
        if(Math.abs(x-y) <= 1){
            return 2*(x + y + z);
        }
        else{
            return result + 2;
        }
    }
}