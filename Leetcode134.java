public class Leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 最快的那个很有意思啊。比我们这个有意思的多
//        for (int i = 0; i < gas.length; i++) {
//            sumGas += gas[i];
//            sumCost += cost[i];
//            tank += gas[i] - cost[i];
//            if (tank < 0) {
//                start = i + 1;
//                tank = 0;
//            }
//        }
        int maxpos=-1;
        int lens=gas.length;
        if (lens==0)
            return maxpos;
        int[] profit=new int[lens];
        int gasmost=0;
        int costget=0;
        for (int pos=0;pos<lens;pos++){
            profit[pos]=gas[pos]-cost[pos];
            gasmost+=gas[pos];
            costget+=cost[pos];
        }
        if (costget>gasmost)
            return maxpos;
        if (lens==1)
            return 0;
        for (int pos=0;pos<lens;pos++){
            if (profit[pos]<0)
                continue;
            if (pos>0&&profit[pos-1]>0||(pos==0&&profit[lens-1]>0))
                continue;
            int myvalue=profit[pos];
            for (int now=pos+1;myvalue>=0;now++){
                now%=lens;
                if (now==pos)
                    break;
                myvalue+=profit[now];
            }
            if (myvalue>=0){
                maxpos=pos;
                break;
            }
        }
        return maxpos;
    }

    public static void main(String[] args){
        int[] gas={3,1,1};
        int[] cost={1,2,2};
        Leetcode134 lc=new Leetcode134();
        lc.canCompleteCircuit(gas,cost);
    }
}
