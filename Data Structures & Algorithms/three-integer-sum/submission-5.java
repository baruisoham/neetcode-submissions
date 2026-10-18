class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1, k=nums.length-1; j<k;){
                final int sum = nums[i] + nums[j] + nums[k];
                if (sum>0) k--;
                else if (sum < 0) j++;
                else{
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(nums[j] == nums[j-1] && j<k) j++;
                    while(nums[k] == nums[k+1] && j<k) k--;
                }
            }
        }
        return result;
    }
}
