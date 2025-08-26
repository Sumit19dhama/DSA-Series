class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : word1.toCharArray()) freq1[c - 'a']++;
        for (char c : word2.toCharArray()) freq2[c - 'a']++;

        int d1 = 0, d2 = 0;
        for (int i = 0; i < 26; i++) {
            if (freq1[i] > 0) d1++;
            if (freq2[i] > 0) d2++;
        }

        // Try all possible swaps (a from word1, b from word2)
        for (int a = 0; a < 26; a++) {
            if (freq1[a] == 0) continue;
            for (int b = 0; b < 26; b++) {
                if (freq2[b] == 0) continue;

                int nd1 = d1, nd2 = d2;

                if (a == b) {
                    if (nd1 == nd2) return true;
                    continue;
                }

                // word1 loses a
                if (freq1[a] == 1) nd1--;
                // word1 gains b
                if (freq1[b] == 0) nd1++;

                // word2 loses b
                if (freq2[b] == 1) nd2--;
                // word2 gains a
                if (freq2[a] == 0) nd2++;

                if (nd1 == nd2) return true;
            }
        }
        return false;
    }
}