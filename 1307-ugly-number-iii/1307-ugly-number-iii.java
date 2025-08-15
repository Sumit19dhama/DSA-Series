class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long low = 1, high = (long) 2 * (long) 1e9; // high bound large enough
        
        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ac = lcm(a, c);
        long abc = lcm(ab, c);

        while (low < high) {
            long mid = low + (high - low) / 2;
            long count = mid / a + mid / b + mid / c
                       - mid / ab - mid / bc - mid / ac
                       + mid / abc;

            if (count < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return (int) low;
    }

    private long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    private long lcm(long x, long y) {
        return x / gcd(x, y) * y;
    }
}