import java.util.Arrays;

public class Weekly_5429 {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res=new int[k];
        int pos=0;
        int left=0;
        int right=arr.length-1;
        int mid=arr[(arr.length-1)/2];
        while (pos<k){
            int tmpl=Math.abs(arr[left]-mid);
            int tmpr=Math.abs(arr[right]-mid);
            if (tmpl>tmpr){
                res[pos++]=arr[left];
                left++;
            }else{
                res[pos++]=arr[right];
                right--;
            }
        }
        return res;
    }
}
