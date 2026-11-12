class Solution {

    public int rob(int[] nums) {
        int[] maxSum = new int[nums.length];

        for(int i=0; i<maxSum.length; i++){
            int lastElem = i<1 ? 0 : maxSum[i-1];
            int secondlastElem = i<2 ? 0 : maxSum[i-2];
            maxSum[i] = Math.max(secondlastElem+ nums[i], lastElem);
        }

        return maxSum[nums.length-1];
    }

}
