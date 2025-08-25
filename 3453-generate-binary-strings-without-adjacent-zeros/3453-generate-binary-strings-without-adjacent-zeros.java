class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(int n, StringBuilder current, List<String> result) {
        if (current.length() == n) {
            result.add(current.toString());
            return;
        }

        current.append('1');
        backtrack(n, current, result);
        current.deleteCharAt(current.length() - 1);

        if (current.length() == 0 || current.charAt(current.length() - 1) != '0') {
            current.append('0');
            backtrack(n, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}