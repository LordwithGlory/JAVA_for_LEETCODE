public class Leetcode122 {
    public int maxProfit(int[] prices) {
        // 贪心 获得现在最大的收益，这个保证后面获得的是相对而言最高于他的俗称长了前后眼。。。
        // 最快的算法是只要后面的大于前面的就把他们的差加起来
        int plen=prices.length;
        if (plen==0)
            return 0;
        int buyprice=prices[0];
        int res=0;
        int sellprice=prices[0];
        for (int pos=1;pos<plen;pos++){
            if (prices[pos]>buyprice){
                if (prices[pos]>sellprice){
                    sellprice=prices[pos];
                }else {
                    res+=sellprice-buyprice;
                    sellprice=buyprice=prices[pos];
                }
            }else {
                res+=sellprice-buyprice;
                sellprice=buyprice=prices[pos];
            }
        }
        res+=sellprice-buyprice;
        return res;
    }
}
