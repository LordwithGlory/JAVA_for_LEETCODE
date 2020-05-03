import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Weekly_5403 {
    public int kthSmallest(int[][] mat, int k) {
        // 用最慢的憨批果然超时
        int rowlen=mat.length;
        int collen=mat[0].length;
        List<Integer> former=new ArrayList<>();
        List<Integer> next=new ArrayList<>();
        former.add(0);
        for (int row=0;row<rowlen;row++){
            for (int col=0;col<collen;col++){
                int num=mat[row][col];
                for (int tmp:former){
                    int addone=num+tmp;
                    next.add(addone);
                }
            }
            Collections.sort(next);
            // 只保留前k个 否则的话将会tle
            if (next.size()<=k)
                former=next;
            else {
                int limit=k;
                while (limit>0){
                    former.clear();
                    limit--;
                    former.add(next.remove(0));
                }
            }
            next=new ArrayList<>();
        }
        return former.get(k-1);
    }
}
