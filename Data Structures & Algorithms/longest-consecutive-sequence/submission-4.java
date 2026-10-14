class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0) return 0;
        int maxCount = 1;
        final HashSet<Integer> numsSet = new HashSet<>();
        for(int num: nums){
            numsSet.add(num);
        }

        for(int i=0; i<nums.length; i++){
            int currentCount = 1;
            if(!numsSet.contains(nums[i]-1)){
                int nextNumber = nums[i]+1;
                while(numsSet.contains(nextNumber)){
                    currentCount++;
                    nextNumber++;
                }
            }
            maxCount = Math.max(maxCount, currentCount);
        }

        return maxCount;
    }
}
