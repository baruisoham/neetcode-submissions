class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Boolean> freqMap = new HashMap<>();
        for(int num: nums){
            boolean isPresent = freqMap.getOrDefault(num, false);
            if(isPresent){
               return true;
            }
            freqMap.put(num, true);
        }
        return false;
    }
}