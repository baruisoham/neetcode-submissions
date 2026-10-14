class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        final int[] prefixArr = new int[nums.length];
        final int[] suffixArr = new int[nums.length];

        int prefixValue = 1;
        int suffixValue=1;

        for(int i=0;i<nums.length; i++){
            
            if(!(i<=0 || i>nums.length-1)){
                prefixValue *= nums[i-1];
                suffixValue *= nums[nums.length-i];
            }
            prefixArr[i] = prefixValue;
            suffixArr[nums.length-1-i] = suffixValue;
        }

        final int[] result = new int[nums.length];

        for(int i=0;i<nums.length; i++){
            result[i] = prefixArr[i]*suffixArr[i];
        }

        return result;
    }
}  
