class Solution {

    private ArrayList<List<Integer>> result;

    private ArrayList<Integer> currentList;

    private int currentSum;
    private int target;

    private int[] nums;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        result = new ArrayList<>();
        currentList = new ArrayList<>();
        currentSum=0;
        this.target=target;
        this.nums=nums;

        Arrays.sort(nums);


        for(int i=0; i<nums.length; i++){
            if(nums[i]>target) break;

            checkSum(i);
        }
        return result;

    }


    private int checkSum(int i){
        if(i>=nums.length) return currentSum;
        if(nums[i]+currentSum>target) return currentSum;

        currentSum+=nums[i];
        currentList.add(nums[i]);
        if(currentSum == target){
            result.add(new ArrayList<>(currentList));
            currentSum-=nums[i];
            currentList.remove(currentList.size()-1);
            return currentSum;
        }

        for(int j=i; j<nums.length; j++){
            checkSum(j);
        }

        currentSum-=nums[i];
        currentList.remove(currentList.size()-1);
        return currentSum;
        
    }

}
