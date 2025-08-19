class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> result = new ArrayList<>();

        for(int i = 0; i < m; i++){
            int left = l[i];
            int right = r[i];

            if(isArithmetic(left, right+1, nums)){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }
        return result;
    }

    private boolean isArithmetic(int left, int right, int[] nums){
        int[] sub = Arrays.copyOfRange(nums, left, right);
        Arrays.sort(sub);

        int diff = sub[1] - sub[0];
        for(int i = 2; i < sub.length; i++){
            if(sub[i] - sub[i-1] != diff){
                return false;
            }
        }
        return true;
    }
}