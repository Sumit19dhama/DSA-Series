class MovieRentingSystem {
    private static class Entry {
        int shop, movie, price;
        Entry(int s, int m, int p) {
            shop = s; movie = m; price = p;
        }
    }

    // Comparator for available movies: by price, then shop
    private static class AvailableComparator implements Comparator<Entry> {
        public int compare(Entry a, Entry b) {
            if (a.price != b.price) return a.price - b.price;
            return a.shop - b.shop;
        }
    }

    // Comparator for rented movies: by price, then shop, then movie
    private static class RentedComparator implements Comparator<Entry> {
        public int compare(Entry a, Entry b) {
            if (a.price != b.price) return a.price - b.price;
            if (a.shop != b.shop) return a.shop - b.shop;
            return a.movie - b.movie;
        }
    }

    private Map<Integer, TreeSet<Entry>> available; // movie -> available copies
    private TreeSet<Entry> rented;                 // all rented copies
    private Map<String, Entry> entryMap;


    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        rented = new TreeSet<>(new RentedComparator());
        entryMap = new HashMap<>();

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            Entry entry = new Entry(shop, movie, price);

            available.computeIfAbsent(movie, k -> new TreeSet<>(new AvailableComparator())).add(entry);

            entryMap.put(key(shop, movie), entry);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;

        TreeSet<Entry> set = available.get(movie);
        Iterator<Entry> it = set.iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            res.add(it.next().shop);
            count++;
        }
        return res;
    }
    
    public void rent(int shop, int movie) {
        Entry e = entryMap.get(key(shop, movie));
        available.get(movie).remove(e);
        rented.add(e);
    }
    
    public void drop(int shop, int movie) {
        Entry e = entryMap.get(key(shop, movie));
        rented.remove(e);
        available.get(movie).add(e);
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        Iterator<Entry> it = rented.iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            Entry e = it.next();
            res.add(Arrays.asList(e.shop, e.movie));
            count++;
        }
        return res;
    }
    private String key(int shop, int movie) {
        return shop + "#" + movie;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */