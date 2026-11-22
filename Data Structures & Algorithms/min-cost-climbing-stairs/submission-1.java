class Solution {
    public int minCostClimbingStairs(int[] cost) {
        

        int[] minCost = new int[cost.length+1];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[0] = 0;
        minCost[1]=0;

        for(int i=2; i<minCost.length; i++){
            int minCost1 = i-1>=0 ? minCost[i-1] + cost[i-1] : Integer.MAX_VALUE;
            int minCost2 = i-2>=0 ? minCost[i-2] + cost[i-2] : Integer.MAX_VALUE;

            minCost[i] = Math.min(minCost1, minCost2);
        }
        return minCost[cost.length];
    }
}
