class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long prefix = 0;
        long minPrefix = 0, maxPrefix = 0;

        for (int d : differences) {
            prefix += d;
            minPrefix = Math.min(minPrefix, prefix);
            maxPrefix = Math.max(maxPrefix, prefix);
        }

        long low = lower - minPrefix;
        long high = upper - maxPrefix;

        return (int)Math.max(0, high - low + 1);
    }
}