class Solution {
    public int maxProfit(int[] prices) {
        int op=0;
        int lsf = Integer.MAX_VALUE;
        for(int i=0; i < prices.length ; i++){
            if(prices[i] < lsf){
                lsf= prices[i];
            } else if(prices[i] - lsf > op){
                op = prices[i] - lsf;
            }
        
        }
        return op;
    }
}