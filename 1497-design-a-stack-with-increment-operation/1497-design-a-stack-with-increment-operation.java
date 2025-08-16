class CustomStack {
    private int[] stack;
    private int[] inc;   // stores pending increments
    private int top;     // index of stack top (-1 means empty)
    private int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.inc = new int[maxSize];
        this.top = -1;
    }

    public void push(int x) {
        if (top + 1 < maxSize) {
            top++;
            stack[top] = x;
        }
    }

    public int pop() {
        if (top == -1) return -1;

        int res = stack[top] + inc[top]; 

        // Propagate increment to the next element down
        if (top > 0) {
            inc[top - 1] += inc[top];
        }

        inc[top] = 0;  // reset after using
        top--;
        return res;
    }

    public void increment (int k, int val) {
        if (top == -1) return;

        int idx = Math.min(k - 1, top);  
        inc[idx] += val;
    }


}


/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */