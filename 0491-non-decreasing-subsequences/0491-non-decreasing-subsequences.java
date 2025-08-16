class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }

        Set<Integer> used = new HashSet<>(); 

        for (int i = start; i < nums.length; i++) {
            if (used.contains(nums[i])) continue;  

            if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
                used.add(nums[i]);
                path.add(nums[i]);
                backtrack(nums, i + 1, path, res);
                path.remove(path.size() - 1); 
            }
        }
    }
}