class Solution {
    public int maxArea(int[] height) {

        int maxarea = 0;
        int i=0;
        int j=height.length-1;

        while(i!=j) {
            if(height[i]<height[j]) {
                maxarea = Math.max(maxarea,(height[i]*(j-i)));
                i++;
            }
            else{
                maxarea = Math.max(maxarea,((j-i)*height[j]));
                j--;
            }
        }
        return maxarea;
    }
}