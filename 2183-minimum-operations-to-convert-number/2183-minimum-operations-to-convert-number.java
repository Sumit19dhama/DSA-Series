class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[1001];

        queue.offer(start);
        int steps = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int s = 0; s < size; s++){
                int x = queue.poll();

                if(x == goal){
                    return steps;
                }
                if(x < 0 || x > 1000 || visited[x]){
                    continue;
                }

                visited[x] = true;
                for(int num : nums){
                    queue.offer(x + num);
                    queue.offer(x- num);
                    queue.offer(x^num);
                }
            }
            steps++;
        }

        return -1;
    }
}