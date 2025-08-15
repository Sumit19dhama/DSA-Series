class Solution {
    public int nonSpecialCount(int l, int r) {
        int limit = (int) Math.sqrt(r); 
        boolean[] isPrime = sieve(limit);

        int specialCount = 0;
        for (int p = 2; p <= limit; p++) {
            if (isPrime[p]) {
                long square = (long) p * p;
                if (square >= l && square <= r) {
                    specialCount++;
                }
            }
        }

        int totalNumbers = r - l + 1;
        return totalNumbers - specialCount; 
    }

    private boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
}