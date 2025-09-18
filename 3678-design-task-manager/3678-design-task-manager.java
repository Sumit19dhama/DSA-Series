class TaskManager {
    private class Task{
        int userId;
        int taskId;
        int priority;
        public Task(int userId, int taskId, int priority){
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }
    private Map<Integer, Task> taskMap;
    private PriorityQueue<Task> maxHeap;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) {
                return b.priority - a.priority;
            }
            return b.taskId - a.taskId;
        });

        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            Task task = new Task(userId, taskId, priority);
            taskMap.put(taskId, task);
            maxHeap.offer(task);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        maxHeap.offer(task);
    }
    
    public void edit(int taskId, int newPriority) {
        if (!taskMap.containsKey(taskId)) {
            return;
        }
        Task old = taskMap.get(taskId);
        Task updated = new Task(old.userId, old.taskId, newPriority);
        taskMap.put(taskId, updated);
        maxHeap.offer(updated);
    }
    
    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }
    
    public int execTop() {
        while (!maxHeap.isEmpty()) {
            Task top = maxHeap.poll();
            Task current = taskMap.get(top.taskId);
            if (current != null && current.priority == top.priority && current.userId == top.userId) {
                taskMap.remove(top.taskId);
                return top.userId;
            }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */