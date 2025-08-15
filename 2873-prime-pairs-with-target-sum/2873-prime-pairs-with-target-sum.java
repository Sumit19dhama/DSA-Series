class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] isPrime = primeNumbers(n);

        for (int x = 2; x <= n / 2; x++) {
            int y = n - x;
            if (isPrime[x] && isPrime[y]) {
                ans.add(Arrays.asList(x, y));
            }
        }
        
        return ans;
    }
    private boolean[] primeNumbers(int n){
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        
        for(int i = 2; i * i <= n; i++){
            if(prime[i]){
                for(int j = i*i; j < n; j += i){
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
}