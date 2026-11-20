class Solution {
    private int total = 0;
    public int subarraySum(int[] nums, int k) {


        int total = 0;


        Map<Integer, Integer> sumMap = new TreeMap<>();

        int currSum = 0;

        sumMap.put(0,1);


        for(int i=0; i<nums.length; i++){
            currSum = nums[i]+currSum;
int toFindKey = currSum - k;
            Integer count = sumMap.get(toFindKey);

            if(count!=null){
                total += count;
            }

            sumMap.put(currSum, sumMap.computeIfAbsent(currSum, a-> 0) + 1);


            
        }

        // for(Map.Entry<Integer, Integer> entry: sumMap.entrySet()){
        //     int toFindKey = entry.getKey() - k;
        //     Integer count = sumMap.get(toFindKey);

        //     if(count!=null){
        //         total += count*entry.getValue();
        //     }
        // }

        return total;
    }

}