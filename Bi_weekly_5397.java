import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bi_weekly_5397 {
    public List<String> simplifiedFractions(int n) {
        Set<Double> hasadd=new HashSet<>();
        List<String> res=new ArrayList<>();
        for (int down=2;down<=n;down++){
            String d=Integer.toString(down);
            for (int up=1;up<down;up++){
                double tmp=up*1.0/down;
                if (hasadd.contains(tmp))
                    continue;
                hasadd.add(tmp);
                res.add(Integer.toString(up)+"/"+d);
            }
        }
        return res;
    }
}
