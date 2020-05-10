import java.util.ArrayList;
import java.util.List;

public class Weekly_5404 {
    public List<String> buildArray(int[] target, int n) {
        List<String> res=new ArrayList<>();
        int lens=target.length;
        int maxnum=target[lens-1];
        int pos=0;
        for (int num=1;num<=maxnum;num++){
            res.add("Push");
            if (target[pos]!=num)
                res.add("Pop");
            else
                pos++;
            if (pos==lens)
                break;
        }
        return res;
    }
}
