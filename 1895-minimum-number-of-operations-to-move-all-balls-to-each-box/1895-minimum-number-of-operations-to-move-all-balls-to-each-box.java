class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        int moves = 0;    
        int balls = 0;    
        for (int i = 0; i < n; i++) {
            answer[i] += moves;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            moves += balls;  
        }

        moves = 0;
        balls = 0;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] += moves;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            moves += balls;
        }

        return answer;
    }
}