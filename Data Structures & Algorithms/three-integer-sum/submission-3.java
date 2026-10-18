class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        final Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            for(int j=i+1, k=nums.length-1; j<k;){
                final int sum = nums[i] + nums[j] + nums[k];
                if (sum==0){
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if (sum>0) k--;
                else j++;
            }
        }
        final List<List<Integer>> resultList = new ArrayList<>();
        for(List<Integer> triplet : result){
            resultList.add(triplet);
        }
        return resultList;
    }
}
