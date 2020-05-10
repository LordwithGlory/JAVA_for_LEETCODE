import java.util.ArrayList;
import java.util.List;

public class Weekly_5405 {
    public int countTriplets(int[] arr) {
        int res=0;
        int xor=arr[0];
        List<Integer> zerosnum=new ArrayList<>();
        for (int pos=1;pos<arr.length;pos++){
            xor^=arr[pos];
            zerosnum.add(xor);
        }
        for (int pos=1;pos<arr.length;pos++){
            int tmp=arr[pos];
            for (int nowpos=0;nowpos<zerosnum.size();nowpos++){
                int now=zerosnum.remove(0);
                if (now==0)
                    res+=nowpos+1;
                now^=tmp;
                zerosnum.add(now);
            }
            zerosnum.remove(0);
        }
        return res;
    }
}
