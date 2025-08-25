class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int left = 0;
        int right = n - 1;

        while(left < n && directions.charAt(left) == 'L'){
            left++;
        }

        while(right >= 0 && directions.charAt(right) == 'R'){
            right--;
        }

        int collisonsCount = 0;
        for(int i = left; i <= right; i++){
            char c = directions.charAt(i);
            if(c == 'S'){
                continue;
            }
            collisonsCount++;
        }

        return collisonsCount;
    }
}