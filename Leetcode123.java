public class Leetcode123 {
    public int maxProfit(int[] prices) {
        if (prices.length==0)
            return 0;
        int[] former=new int[prices.length];
        int[] backer=new int[prices.length];
        int minval=prices[0];
        former[0]=0;
        for (int pos=1;pos<prices.length;pos++){
            if (prices[pos]<minval){
                former[pos]=former[pos-1];
                minval=prices[pos];
            }else {
                if (prices[pos]-minval>former[pos-1])
                    former[pos]=prices[pos]-minval;
                else
                    former[pos]=former[pos-1];
            }
        }
        int res=former[prices.length-1];
        int maxvalue=prices[prices.length-1];
        backer[prices.length-1]=0;
        for(int pos=prices.length-2;pos>=0;pos--){
            if (prices[pos]>maxvalue){
                maxvalue=prices[pos];
                backer[pos]=backer[pos+1];
            }else {
                if (maxvalue-prices[pos]>backer[pos+1])
                    backer[pos]=maxvalue-prices[pos];
                else
                    backer[pos]=backer[pos+1];
            }
            res=res>backer[pos+1]+former[pos]?res:backer[pos+1]+former[pos];
        }
        return res;
//        int maxp=0;
//        int minp=0;
//        int plen=prices.length;
//        if (plen==0)
//            return 0;
//        int sellprice=prices[0];
//        int buyprice=prices[0];
//        for (int num=1;num<plen;num++){
//            if (prices[num]>sellprice){
//                sellprice=prices[num];
//            }else {
//                int tmp=sellprice-buyprice;
//                if (tmp>maxp){
//                    minp=maxp;
//                    maxp=tmp;
//                }else if (tmp>minp)
//                    minp=tmp;
//                sellprice=buyprice=prices[num];
//            }
//        }
//        int tmp=sellprice-buyprice;
//        if (tmp>maxp){
//            minp=maxp;
//            maxp=tmp;
//        }else if (tmp>minp)
//            minp=tmp;
//        return maxp+minp;
    }
}
