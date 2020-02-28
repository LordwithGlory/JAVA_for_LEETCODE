import java.util.ArrayList;
import java.util.List;

public class Leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 最快的用了二维数组然后进行的完全是DP
        int lllen=triangle.size();
        if (lllen==1){
            return triangle.get(0).get(0);
        }else if (lllen==0)
            return 0;
        List<Integer> old=null;
        List<Integer> now=null;
        for (int pos=lllen-2;pos>=0;pos--){
            if (now==null)
                old=triangle.remove(pos+1);
            else
                old=new ArrayList<>(now);
            now=triangle.remove(pos);
            for (int tmpos=0;tmpos<now.size();tmpos++){
                int minval=now.remove(tmpos);
                minval+=Math.min(old.get(tmpos),old.get(tmpos+1));
                now.add(tmpos,minval);
            }
        }
        return now.get(0);
    }
}
