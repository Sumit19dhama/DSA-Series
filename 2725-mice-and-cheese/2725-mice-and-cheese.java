class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int total = 0;
        int n = reward1.length;

        for(int r : reward2){
            total += r;
        }

        int[] diff = new int[n];
        for(int i = 0; i < n; i++){
            diff[i] = reward1[i] - reward2[i];
        }

        Arrays.sort(diff);

        for(int i = 0; i < k; i++){
            total += diff[n - i - 1];
        }

        return total;
    }

}