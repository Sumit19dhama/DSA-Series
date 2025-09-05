class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequencies
        for (int n : arr) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // Store frequencies in a set
        Set<Integer> seen = new HashSet<>(freq.values());

        // If unique counts == map size, all occurrences are unique
        return seen.size() == freq.size();
    }
}