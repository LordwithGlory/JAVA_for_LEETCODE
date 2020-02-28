public class Leetcode121 {
    public int maxProfit(int[] prices) {
        // 最快那个是找最小的
        int maxhave=0;
        int maxv=0;
        int prclen=prices.length;
        if (prclen==0)
            return 0;
        maxhave=prices[prclen-1];
        for (int pos=prclen-2;pos>=0;pos--){
            if (prices[pos]>maxhave){
                maxhave=prices[pos];
            }else {
                maxv=maxv>maxhave-prices[pos]?maxv:maxhave-prices[pos];
            }
        }
        return maxv;
    }
}
