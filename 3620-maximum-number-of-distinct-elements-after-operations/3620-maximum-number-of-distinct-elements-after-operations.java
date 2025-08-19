class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int nextFree = Integer.MIN_VALUE;  

        for (int num : nums) {
            int assign = Math.max(num - k, nextFree);
            if (assign <= num + k) {
                count++;
                nextFree = assign + 1; 
            }
        }

        return count;



        // Arrays.sort(nums);
        // HashSet<Integer> used = new HashSet<>();

        // for(int num : nums){
            
        //     for(int i = num-k; i <= num+k; i++){
        //         if(!used.contains(i)){
        //             used.add(i);
        //             break;
        //         }
        //     }
        // }
        // return used.size();
    }
}