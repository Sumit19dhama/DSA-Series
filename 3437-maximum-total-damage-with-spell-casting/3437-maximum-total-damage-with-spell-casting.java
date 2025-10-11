class Solution {
    public long maximumTotalDamage(int[] power) {
        if (power == null || power.length == 0) return 0;

        // Step 1: Combine duplicate damages
        Map<Integer, Long> totalDamage = new HashMap<>();
        for (int p : power) {
            totalDamage.put(p, totalDamage.getOrDefault(p, 0L) + p);
        }

        // Step 2: Sort unique damage values
        List<Integer> unique = new ArrayList<>(totalDamage.keySet());
        Collections.sort(unique);

        // Step 3: Memoization
        Long[] memo = new Long[unique.size()];

        return dfs(unique, totalDamage, unique.size() - 1, memo);
    }

    private static long dfs(List<Integer> unique, Map<Integer, Long> totalDamage, int i, Long[] memo) {
        if (i < 0) return 0;
        if (memo[i] != null) return memo[i];

        int val = unique.get(i);
        long dmg = totalDamage.get(val);

        // Binary search for last index j with unique[j] < val - 2
        int left = 0, right = i - 1, j = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (unique.get(mid) < val - 2) {
                j = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Option 1: Take this spell
        long take = dmg + dfs(unique, totalDamage, j, memo);

        // Option 2: Skip it
        long skip = dfs(unique, totalDamage, i - 1, memo);

        memo[i] = Math.max(take, skip);
        return memo[i];
    }
}