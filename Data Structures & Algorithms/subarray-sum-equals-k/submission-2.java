class Solution {
    private int total = 0;
    public int subarraySum(int[] nums, int k) {
        // sum(nums, 0, k, 0);
        // return total;


        int total = 0;


        int[] sums = new int[nums.length+1];
        int currSum = 0;

        sums[0] = 0;

        for(int i=1; i<=nums.length; i++){
            sums[i] = nums[i-1]+currSum;
            currSum = sums[i];
        }

        for(int i=0; i<sums.length; i++){
            for(int j = sums.length-1; j>i; j--){
                if(sums[j]-sums[i]==k) total++;
            }
        }
        return total;
    }

    private void sum(int[] nums, int i, int target, int sum){
        if(target == sum) total++;

        if(i>=nums.length) return;


        sum(nums, i+1, target, 0);
        sum(nums, i+1, target, sum+nums[i]);
    }

}