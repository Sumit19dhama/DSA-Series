class Solution {
    public char kthCharacter(int k) {
        return findChar(k);
    }
     private char findChar(int k) {
        // Base: first character is always 'a'
        if (k == 1) return 'a';

        // Find largest power of 2 less than k
        int highestPower = 1;
        while (highestPower * 2 < k) {
            highestPower *= 2;
        }

        // length of half = highestPower
        if (k == highestPower + 1) {
            // First char of shifted part = shift of first char
            char prev = findChar(1);
            return shift(prev);
        } else {
            // Otherwise, reduce problem
            char prev = findChar(k - highestPower);
            return shift(prev);
        }
    }

    private char shift(char c) {
        return (c == 'z') ? 'a' : (char)(c + 1);
    }
}