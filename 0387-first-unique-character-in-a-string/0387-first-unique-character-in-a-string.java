class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;

            queue.offer(i);
            
            while (!queue.isEmpty() && freq[s.charAt(queue.peek()) - 'a'] > 1) {
                queue.poll();
            }
        }

        return queue.isEmpty() ? -1 : queue.peek();
    }
}