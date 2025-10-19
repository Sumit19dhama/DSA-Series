class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String smallest = s;

        queue.offer(s);
        visited.add(s);

        int n = s.length();

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.compareTo(smallest) < 0) {
                smallest = curr;
            }

            // Operation 1: Add 'a' to all odd indices
            char[] chars = curr.toCharArray();
            for (int i = 1; i < n; i += 2) {
                int newDigit = ((chars[i] - '0') + a) % 10;
                chars[i] = (char) (newDigit + '0');
            }
            String added = new String(chars);

            // Operation 2: Rotate right by 'b'
            String rotated = curr.substring(n - b) + curr.substring(0, n - b);

            // Add new states if unseen
            if (visited.add(added)) queue.offer(added);
            if (visited.add(rotated)) queue.offer(rotated);
        }

        return smallest;
    }
}