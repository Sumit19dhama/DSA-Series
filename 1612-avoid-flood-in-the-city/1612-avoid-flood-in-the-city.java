class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> fullLakes = new HashMap<>(); // lake -> last day it was filled
        TreeSet<Integer> dryDays = new TreeSet<>(); // indices of days we can dry

        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                int lake = rains[i];
                ans[i] = -1; // raining day
                
                if (fullLakes.containsKey(lake)) {
                    // lake already full — we need to find a dry day after the last fill
                    Integer dryDay = dryDays.higher(fullLakes.get(lake));
                    if (dryDay == null) {
                        // no available dry day — flood unavoidable
                        return new int[0];
                    }
                    // dry the lake on this dry day
                    ans[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                // update last time this lake got filled
                fullLakes.put(lake, i);
            } else {
                // dry day, we’ll decide later which lake to dry
                dryDays.add(i);
                ans[i] = 1; // temporary placeholder (any lake)
            }
        }
        return ans;
    }
}