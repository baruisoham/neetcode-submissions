class Solution {
    public int maxProfit(int[] prices) {
        Integer buy = prices[0];
        int maxProfit = 0;

        for(int j=1; j<=prices.length-1; j++){
            final int sell = prices[j];
            maxProfit = Math.max(maxProfit, sell-buy);
            if(sell<buy) buy=prices[j];
        }
        return maxProfit;

    }
}
