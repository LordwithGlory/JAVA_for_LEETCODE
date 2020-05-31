import java.util.*;

public class Bi_weekly_5410 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> res=new ArrayList<>();
        List<Integer>[] des=new ArrayList[n];
        for (int prepos=0;prepos<prerequisites.length;prepos++){
            int begin=prerequisites[prepos][0];
            int end=prerequisites[prepos][1];
            if (des[begin]==null)
                des[begin]=new ArrayList();
            des[begin].add(end);
        }
        for (int pos=0;pos<queries.length;pos++){
            int mubegin=queries[pos][0];
            int myend=queries[pos][1];
            Set<Integer> hasfound=new HashSet<>();
            Queue<Integer> queue=new LinkedList<>();
            queue.add(mubegin);
            while (!queue.isEmpty()){
                int now=queue.poll();
                if (now==myend){
                    res.add(true);
                    break;
                }
                if (des[now]==null)
                    continue;
                for (int num:des[now]){
                    if (hasfound.contains(num))
                        continue;
                    queue.add(num);
                    hasfound.add(num);
                }
            }
            if (res.size()==pos)
                res.add(false);
        }
        return res;
    }
}
