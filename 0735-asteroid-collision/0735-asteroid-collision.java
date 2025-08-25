class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int a : asteroids){
            boolean destroyed = false;

            while(!stack.isEmpty() && a < 0 && stack.peek() > 0){
                int top = stack.peek();

               if (Math.abs(a) > top) {
                    stack.pop(); 
                } else if (Math.abs(a) == top) {
                    stack.pop(); 
                    destroyed = true;
                    break;
                } else {
                    destroyed = true; 
                    break;
                }
            }

            if (!destroyed) {
                stack.push(a);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}