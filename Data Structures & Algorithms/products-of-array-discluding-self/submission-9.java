class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        // final int[] prefixArr = new int[nums.length];
        // final int[] suffixArr = new int[nums.length];

        // int prefixValue = 1;
        // int suffixValue=1;

        // for(int i=0;i<nums.length; i++){
            
        //     if(!(i<=0 || i>nums.length-1)){
        //         prefixValue *= nums[i-1];
        //         suffixValue *= nums[nums.length-i];
        //     }
        //     prefixArr[i] = prefixValue;
        //     suffixArr[nums.length-1-i] = suffixValue;
        // }

        // final int[] result = new int[nums.length];

        // for(int i=0;i<nums.length; i++){
        //     result[i] = prefixArr[i]*suffixArr[i];
        // }
        final int size = nums.length;
        final int[] result = new int[size];
        Arrays.fill(result, 1);

        int prefixValue = 1;
        int suffixValue=1;

        for(int i=0; i<size; i++){
            if(i>=1) prefixValue *= nums[i-1];
            result[i] *=prefixValue;
            final int j = size-1-i;
            if(j<size-1) suffixValue *= nums[j+1];
            result[j]*=suffixValue;

        }

        return result;
    }
}  
