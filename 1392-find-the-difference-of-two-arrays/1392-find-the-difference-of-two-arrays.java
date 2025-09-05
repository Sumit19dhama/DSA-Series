class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n : nums1) set1.add(n);
        for (int n : nums2) set2.add(n);

        // Elements in set1 but not in set2
        List<Integer> diff1 = new ArrayList<>();
        for (int n : set1) {
            if (!set2.contains(n)) {
                diff1.add(n);
            }
        }

        // Elements in set2 but not in set1
        List<Integer> diff2 = new ArrayList<>();
        for (int n : set2) {
            if (!set1.contains(n)) {
                diff2.add(n);
            }
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(diff1);
        answer.add(diff2);

        return answer;
    }
}