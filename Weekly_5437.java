import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Weekly_5437 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        List<Integer> hasoccured=new ArrayList<>();
        int occurs=1;
        for (int pos=1;pos<arr.length;pos++){
            if (arr[pos]==arr[pos-1]){
                occurs++;
                continue;
            }
            hasoccured.add(occurs);
            occurs=1;
        }
        hasoccured.add(occurs);
        Collections.sort(hasoccured);
        while (k>0&&hasoccured.size()>0){
            if (hasoccured.get(0)<=k){
                k-=hasoccured.get(0);
                hasoccured.remove(0);
                continue;
            }else
                break;
        }
        return hasoccured.size();
    }
}
