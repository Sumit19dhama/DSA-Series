class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();

        // Step 1: Extract vowels
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        // Step 2: Sort vowels by ASCII
        Collections.sort(vowels);

        // Step 3: Rebuild string with sorted vowels
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                result.append(vowels.get(vowelIndex++));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}