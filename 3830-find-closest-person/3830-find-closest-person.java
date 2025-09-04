class Solution {
    public int findClosest(int x, int y, int z) {
        int xSteps = Math.abs(z - x);
        int ySteps = Math.abs(z - y);

        if(xSteps == ySteps){
            return 0;
        } 
        else if(xSteps < ySteps){
            return 1;
        }

        return 2;
    }
}