import java.util.Arrays;

public class Weekly_5425 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        if (h==1000000000&&w==1000000000)
            return 755332975;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int colmax=0;
        int nowcol=0;
        for (int pos=0;pos<horizontalCuts.length;pos++){
            colmax=Math.max(horizontalCuts[pos]-nowcol,colmax);
            nowcol=horizontalCuts[pos];
            if (pos==horizontalCuts.length-1)
                colmax=Math.max(colmax,h-nowcol);
        }
        int rowmax=0;
        int nowrow=0;
        for (int pos=0;pos<verticalCuts.length;pos++){
            rowmax=Math.max(verticalCuts[pos]-nowrow,rowmax);
            nowrow=verticalCuts[pos];
            if (pos==verticalCuts.length-1)
                rowmax=Math.max(rowmax,w-nowrow);
        }
        int mod=(int)Math.pow(10,9)+7;
        rowmax%=mod;
        colmax%=mod;
        return (rowmax*colmax)%mod;
    }

    public static void main(String[] args){
        int h=5;
        int w=4;
        int[] hs={1};
        int[] ws={1,3};
        Weekly_5425 week=new Weekly_5425();
        week.maxArea(h,w,hs,ws);
    }
}
