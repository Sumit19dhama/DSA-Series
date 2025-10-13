class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]); // always keep the first word

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            // Compare sorted versions to check anagram
            if (!isAnagram(prev, curr)) {
                result.add(curr);
            }
        }

        return result;
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}