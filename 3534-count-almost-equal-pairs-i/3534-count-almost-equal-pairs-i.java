class Solution {
     private static String normalize(String a, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - a.length(); i++) {
            sb.append('0');
        }
        sb.append(a);
        return sb.toString();
    }

    // check if two numbers are almost equal
    private static boolean isAlmostEqual(String a, String b) {
        if (a.equals(b)) return true;
        if (a.length() != b.length()) return false;

        char[] arr = a.toCharArray();
        int n = arr.length;

        // try all possible one swaps in a
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(arr, i, j);
                if (new String(arr).equals(b)) {
                    swap(arr, i, j); // revert before returning
                    return true;
                }
                swap(arr, i, j); // revert
            }
        }
        return false;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int countPairs(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String a = String.valueOf(nums[i]);
                String b = String.valueOf(nums[j]);

                // normalize both to same length
                int maxLen = Math.max(a.length(), b.length());
                a = normalize(a, maxLen);
                b = normalize(b, maxLen);

                if (isAlmostEqual(a, b) || isAlmostEqual(b, a)) {
                    count++;
                }
            }
        }
        return count;
    }
    
}