import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Leetcode152 {
    public int maxsub(int[] nums,int begin,int end,int minis){
        // 最快的那个和俺的异曲同工，俺试试
        // 俺开始不知道一个也可以。。。
        if (end==begin+1)
            return 0;
        int res=nums[begin];
        int former=end;
        int backer=0;
        int fomerres=1;
        int backeres=1;
        for (int pos=begin;pos<end;pos++){
            res*=nums[pos];
            if (nums[pos]<0){
                if (pos<former){
                    former=pos;
                    fomerres=res;
                }
                if (pos>backer){
                    backer=pos;
                    backeres=res/nums[pos];
                }
            }
        }
        backeres=res/backeres;
        if (res<0){
            if (fomerres<backeres&&backer<0)
                fomerres=backeres;
        }
        return res;
    }
    public int maxProduct(int[] nums) {
        int lens=nums.length;
        int begin=0;
        int res=nums[0];
        int minuscount=0;
        for (int pos=0;pos<lens;pos++){
            int tmp=0;
            if (nums[pos]==0){
                if (begin!=pos){
                    tmp=maxsub(nums,begin,pos,minuscount);
                    res= Math.max(res, tmp);
                }
                minuscount=0;
                begin=pos+1;
            }else if (nums[pos]<0)
                minuscount++;
        }
        int tmp=maxsub(nums,begin,lens,minuscount);
        if (tmp>res)
            return tmp;
        return res;
    }

    public int maxProd(int[] nums){
        if (nums.length==0)
            return 0;
        int minres=nums[0];
        int maxres=nums[0];
        int res=minres;
        for (int pos=1;pos<nums.length;pos++){
            int tmp1= Math.max(Math.max(minres*nums[pos],maxres*nums[pos]),nums[pos]);
            minres=Math.min(Math.min(minres*nums[pos],maxres*nums[pos]),nums[pos]);
            maxres=tmp1;
            if (maxres>res)
                res=maxres;
        }
        return res;
    }

    public static void main(String[] args){
        int[] numes={-3,-4};
        Leetcode152 lc=new Leetcode152();
        System.out.println(lc.maxProd(numes));
    }
}
