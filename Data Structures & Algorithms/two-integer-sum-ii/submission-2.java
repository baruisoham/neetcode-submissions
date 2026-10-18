class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int idx1 = 0;
        int idx2=numbers.length-1;

        while(idx1<idx2){
            final int a = numbers[idx1];
            final int b = numbers[idx2];
            if(a+b==target){
                break;
            }
            else if(a+b>target){
                idx2--;
            }
            else idx1++;
        }
        return new int[] {idx1+1,idx2+1};
                                                          
    }
}
