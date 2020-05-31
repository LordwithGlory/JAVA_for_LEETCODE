public class Bi_weekly_5408 {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length!=arr.length)
            return false;
        int res=0;
        for (int num:target)
            res^=num;
        for (int num:arr)
            res^=num;
        if (res==0)
            return true;
        else
            return false;
    }
}
