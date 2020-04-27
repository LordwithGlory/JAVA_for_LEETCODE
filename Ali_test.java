import java.util.ArrayList;
import java.util.List;

public class Ali_test {
    public List<Double> luckymoney(int m,int n){
        List<Double> res=new ArrayList<>();
        // 保证每个人最少一分钱
        if (n*0.01<m)
            return null;
        double money=(double)m;
        while (n>0){
            n--;
            double percent=Math.random();
            // 为保证最小的单位是1分 所以需要小数点后面两个0
            double rest=(int)(money*percent*100)/100.0;
            // 如果少于一分钱的话重新计算
            while (rest<n*0.01){
                // 如果剩下的钱不够的话使用现在的钱和余钱的中间值来作为余下的钱
                int temp=(int)(rest*100)+(int) (money*100);
                if (temp%2!=0)
                    temp+=1;
                rest=temp/200.0;
                // 重新来获得一个随机值 耗时比较大
//                percent=Math.random();
//                rest=(int)(money*percent*100)/100.0;
            }
            money=rest;
            res.add(money-rest);
        }
        return res;
    }
    public List<Integer> quicksort(List<Integer> mysort){
        List<Integer> res=new ArrayList<>();
        List<Integer> left=new ArrayList<>();
        List<Integer> right=new ArrayList<>();
        if (mysort.size()==0)
            return res;
        // 作为二分的轴心部位
        int povit=mysort.remove(0);
        int pcount=1;
        while (mysort.size()>0){
            int num=mysort.remove(0);
            // 分为左侧右侧和中间，中间用来减小工作量
            if (num<povit)
                left.add(num);
            else if (num>pcount)
                right.add(num);
            else
                pcount++;
        }
        left=quicksort(left);
        right=quicksort(right);
        res.addAll(left);
        while (pcount>0){
            res.add(povit);
            pcount--;
        }
        res.addAll(right);
        return res;
    }

}
