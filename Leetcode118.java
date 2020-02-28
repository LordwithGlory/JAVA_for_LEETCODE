import java.util.ArrayList;
import java.util.List;

public class Leetcode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        for (int num=0;num<numRows;num++){
            List<Integer> mylist=new ArrayList<>();
            mylist.add(1);
            if (num==0){
                res.add(mylist);
                continue;
            }
            List<Integer> oldlist=res.get(num-1);
            for(int needadd=1;needadd<num;needadd++){
                mylist.add(oldlist.get(needadd-1)+oldlist.get(needadd));
            }
            mylist.add(1);
            res.add(mylist);
        }
        return res;
    }
}
