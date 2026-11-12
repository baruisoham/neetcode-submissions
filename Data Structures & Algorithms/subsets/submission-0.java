class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i=0; i<nums.length; i++){
            findSubsets(nums[i], result);
        }
        return result;
    }

    public void findSubsets(int num, List<List<Integer>> result){
        int size = result.size();
        for(int i=0; i<size; i++){
            List<Integer> newList = new ArrayList<>(result.get(i));
            newList.add(num);
            result.add(newList);
        }
    }

}
