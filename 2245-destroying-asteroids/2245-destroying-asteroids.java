class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long pMass = mass;  
        
        for (int a : asteroids) {
            if (pMass < a) {
                return false; 
            }
            pMass += a; 
        }
        
        return true;
    }
}