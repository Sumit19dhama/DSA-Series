class Solution {
    private static final double EPSILON = 1e-6;
    private static final double TARGET = 24.0;
    
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int c : cards) nums.add((double) c);
        return backtrack(nums);
    }

    private boolean backtrack(List<Double> nums) {
        // Base case: only one number left
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - TARGET) < EPSILON;
        }

        // Try all pairs of numbers
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) continue;

                // New list after removing nums[i] and nums[j]
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) next.add(nums.get(k));
                }

                // Try all operations
                for (double val : compute(nums.get(i), nums.get(j))) {
                    next.add(val);
                    if (backtrack(next)) return true;
                    next.remove(next.size() - 1); // backtrack
                }
            }
        }
        return false;
    }

    private List<Double> compute(double a, double b) {
        List<Double> results = new ArrayList<>();
        results.add(a + b);
        results.add(a - b);
        results.add(b - a);
        results.add(a * b);
        if (Math.abs(b) > EPSILON) results.add(a / b);
        if (Math.abs(a) > EPSILON) results.add(b / a);
        return results;
    }
}