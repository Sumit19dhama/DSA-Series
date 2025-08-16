class Solution {
    private final int MOD = 1_000_000_007;
    public int countNicePairs(int[] nums) {
        Map<Integer, Long> freq = new HashMap<>();
        
        for (int num : nums) {
            int key = num - reverse(num);
            freq.put(key, freq.getOrDefault(key, 0L) + 1);
        }

        long ans = 0;
        for (long f : freq.values()) {
            // f*(f-1)/2 to calculate total no. of pairs for same f keys

            ans = (ans + (f * (f - 1) / 2) % MOD) % MOD;
        }

        return (int) ans;
    }

    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }
}