class Router {
    private final int memoryLimit;
    private final Queue<Packet> fifo; 
    private final Set<String> seen;
    private final Map<Integer, TreeMap<Integer, Integer>> prefixCount; 
    // destination -> cumulative count over time

    private static class Packet {
        int source, destination, timestamp;
        Packet(int s, int d, int t) {
            source = s;
            destination = d;
            timestamp = t;
        }
    }

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.fifo = new LinkedList<>();
        this.seen = new HashSet<>();
        this.prefixCount = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (seen.contains(key)) return false; // duplicate

        // Evict oldest if memory full
        if (fifo.size() >= memoryLimit) {
            removeOldest();
        }

        Packet p = new Packet(source, destination, timestamp);
        fifo.offer(p);
        seen.add(key);

        // update prefix sums for this destination
        prefixCount.computeIfAbsent(destination, k -> new TreeMap<>());
        TreeMap<Integer, Integer> tree = prefixCount.get(destination);
        int prevSum = tree.isEmpty() ? 0 : tree.lastEntry().getValue();
        tree.put(timestamp, prevSum + 1);

        return true;
    }

    private void removeOldest() {
        Packet old = fifo.poll();
        String oldKey = old.source + "#" + old.destination + "#" + old.timestamp;
        seen.remove(oldKey);

        TreeMap<Integer, Integer> tree = prefixCount.get(old.destination);
        if (tree == null) return;

        // Decrement all prefix sums after old.timestamp
        // We need to rebuild suffix sums efficiently
        // Solution: adjust from old.timestamp onwards
        NavigableMap<Integer, Integer> tail = tree.tailMap(old.timestamp, true);
        for (Map.Entry<Integer, Integer> e : new ArrayList<>(tail.entrySet())) {
            tree.put(e.getKey(), e.getValue() - 1);
        }

        // Clean up if empty
        if (tree.isEmpty() || tree.lastEntry().getValue() == 0) {
            prefixCount.remove(old.destination);
        }
    }

    public int[] forwardPacket() {
        if (fifo.isEmpty()) return new int[0];
        Packet p = fifo.poll();
        String key = p.source + "#" + p.destination + "#" + p.timestamp;
        seen.remove(key);

        // decrement prefix sums
        TreeMap<Integer, Integer> tree = prefixCount.get(p.destination);
        if (tree != null) {
            NavigableMap<Integer, Integer> tail = tree.tailMap(p.timestamp, true);
            for (Map.Entry<Integer, Integer> e : new ArrayList<>(tail.entrySet())) {
                tree.put(e.getKey(), e.getValue() - 1);
            }
            if (tree.isEmpty() || tree.lastEntry().getValue() == 0) {
                prefixCount.remove(p.destination);
            }
        }

        return new int[]{p.source, p.destination, p.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        TreeMap<Integer, Integer> tree = prefixCount.get(destination);
        if (tree == null) return 0;

        // prefix sum up to endTime
        Map.Entry<Integer, Integer> endEntry = tree.floorEntry(endTime);
        int endSum = (endEntry == null) ? 0 : endEntry.getValue();

        // prefix sum before startTime
        Map.Entry<Integer, Integer> startEntry = tree.floorEntry(startTime - 1);
        int startSum = (startEntry == null) ? 0 : startEntry.getValue();

        return endSum - startSum;
    }
}



/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */