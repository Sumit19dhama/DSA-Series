class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int countHomogenous(String s) {
        long result = 0;
        int n = s.length();
        int i = 0;

        while (i < n) {
            int j = i;
            // expand while same char
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            long len = j - i;
            // add number of homogenous substrings in this block
            result = (result + (len * (len + 1) / 2) % MOD) % MOD;
            i = j; // move to next block
        }

        return (int) result;
    }
}