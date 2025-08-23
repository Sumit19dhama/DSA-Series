class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> freq.get(b) - freq.get(a)
        );
        pq.addAll(freq.keySet());

        StringBuilder result = new StringBuilder();
        Character prev = null;

        while (!pq.isEmpty()) {
            char current = pq.poll();
            result.append(current);
            freq.put(current, freq.get(current) - 1);

            if (prev != null && freq.get(prev) > 0) {
                pq.offer(prev);
            }

            prev = current;
        }

        return result.length() == s.length() ? result.toString() : "";
    }
}