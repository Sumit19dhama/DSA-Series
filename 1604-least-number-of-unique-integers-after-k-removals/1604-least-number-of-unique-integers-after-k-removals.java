class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minPQ = new PriorityQueue<>(map.values());

        int uniqueCount = map.size();
        while( k>0 && !minPQ.isEmpty()){
            int freq = minPQ.poll();
            if(k >= freq){
                k -= freq;
                uniqueCount--;
            }
            else{
                break;
            }
        }
        return uniqueCount;
    }
}