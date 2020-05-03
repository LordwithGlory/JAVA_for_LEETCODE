import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Weekly_5400 {
    public String destCity(List<List<String>> paths) {
        Set<String> has_next=new HashSet<>();
        Set<String> endpoint=new HashSet<>();
        for (List<String> onepath:paths){
            String begin=onepath.get(0);
            String end=onepath.get(1);
            if (!has_next.contains(begin)){
                has_next.add(begin);
                if (endpoint.contains(begin))
                    endpoint.remove(begin);
            }
            if (has_next.contains(end))
                continue;
            if (!endpoint.contains(end))
                endpoint.add(end);
        }
        for (String res:endpoint)
            return res;
        return null;
    }
}
