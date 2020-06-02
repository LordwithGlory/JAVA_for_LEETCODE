import java.security.KeyPair;
import java.util.*;

public class Weekly_5426 {
    public int mReorder(int n, int[][] connections){
        int res=0;
        List<Integer>[] canreach=new List[n];
        Set<String> myoath=new HashSet<>();
        for (int pos=0;pos<connections.length;pos++){
            int begin=connections[pos][0];
            int end=connections[pos][1];
            myoath.add(begin+" "+end);
            if (canreach[begin]==null)
                canreach[begin]=new ArrayList<>();
            if (canreach[end]==null)
                canreach[end]=new ArrayList<>();
            canreach[begin].add(end);
            canreach[end].add(begin);

        }
        boolean[] hasviewed=new boolean[n];
        hasviewed[0]=true;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            int now=queue.poll();
            for (int num:canreach[now]){
                if (hasviewed[num])
                    continue;
                hasviewed[num]=true;
                queue.add(num);
                if (!myoath.contains(num+" "+now))
                    res++;
            }
        }
        return res;
    }
    public int minReorder(int n, int[][] connections) {
        Set<Integer> allright=new HashSet<>();
        for (int now=0;now<n;now++)
            allright.add(now);
        allright.remove(0);
        List<Integer>[] mybegin=new ArrayList[n];
        for (int pos=0;pos<connections.length;pos++){
            int begin=connections[pos][0];
            int end=connections[pos][1];
            if (mybegin[end]==null)
                mybegin[end]=new ArrayList<>();
            mybegin[end].add(begin);
            if (!allright.contains(end))
                allright.remove(begin);
        }
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            int now=queue.poll();
            for (int tmp:mybegin[now]){
                if (!allright.contains(tmp))
                    continue;
                queue.add(tmp);
                allright.remove(tmp);
            }
        }
        int res=0;
        while (allright.size()>0){
            Set<Integer> tmpset=new HashSet<>();
            tmpset.addAll(allright);
            for (int num:tmpset){
                for (int tmp:mybegin[num]){
                    if (allright.contains(tmp))
                        continue;
                    res++;
                    allright.remove(num);
                    for (int tmpnum:mybegin[num]){
                        if (allright.contains(tmpnum))
                            allright.remove(tmpnum);
                    }
                    break;
                }
            }
        }
        return res;
    }
}
