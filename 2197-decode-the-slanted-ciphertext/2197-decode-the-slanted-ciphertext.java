class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText == null || encodedText.length() == 0) return "";
        
        int m = rows;
        int n = encodedText.length() / rows;  
        
        char[][] mat = new char[m][n];
        int idx = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                mat[r][c] = encodedText.charAt(idx++);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int startCol = 0; startCol < n; startCol++) {
            int r = 0, c = startCol;
            while (r < m && c < n) {
                sb.append(mat[r][c]);
                r++;
                c++;
            }
        }
        
        int end = sb.length();
        while (end > 0 && sb.charAt(end - 1) == ' ') {
            end--;
        }
        
        return sb.substring(0, end);
    }
}