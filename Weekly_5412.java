public class Weekly_5412 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res=0;
        for (int pos=0;pos<startTime.length;pos++){
            if (startTime[pos]<=queryTime&&endTime[pos]>=queryTime)
                res++;
        }
        return res;
    }
}
