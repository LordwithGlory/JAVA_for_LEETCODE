import java.util.ArrayList;
import java.util.List;

public class Leetcode119 {
    public List<Integer> getRow(int rowIndex) {
        // 最快的那个居然用了对称。。。
        List<Integer> res=new ArrayList<Integer>();
        for (int num=0;num<=rowIndex;num++){
            List<Integer> old=new ArrayList<>(res);
            res.clear();
            res.add(1);
            if (num==0)
                continue;
            for (int mypos=1;mypos<num;mypos++){
                res.add(old.get(mypos-1)+old.get(mypos));
            }
            res.add(1);
        }
        return res;
    }
}
