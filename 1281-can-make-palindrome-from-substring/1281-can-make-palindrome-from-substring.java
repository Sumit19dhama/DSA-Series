class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[] prefixMask = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int charBit = 1 << (s.charAt(i) - 'a');
            prefixMask[i + 1] = prefixMask[i] ^ charBit;
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2];

            int mask = prefixMask[r + 1] ^ prefixMask[l];

            int oddCount = Integer.bitCount(mask);

            int needed = oddCount / 2;

            result.add(needed <= k);
        }
        return result;
    }
}