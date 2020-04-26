import java.util.Scanner;

public class TX_summer_0426_2 {
    public void getdistance(Scanner scanner){
        int lens=scanner.nextInt();
        int reallen=lens*2;
        int[] setx=new int[reallen];
        int[] sety=new int[reallen];
        System.out.println(lens);
        for (int pos=0;pos<reallen*2;pos++){
            if (pos<lens){
                if (pos%2==0)
                    setx[pos]=scanner.nextInt();
                else
                    sety[pos]=scanner.nextInt();
            }else {
                int tmp=pos-lens;
                if (tmp%2==0)
                    setx[pos]=scanner.nextInt();
                else
                    sety[pos]=scanner.nextInt();
            }
        }
        double res=Double.MAX_VALUE;
        for (int posa=0;posa<lens;posa++){
            int xa=setx[posa];
            int ya=sety[posa];
            for (int posb=lens;posb<reallen;posb++){
                int xb=setx[posb];
                int yb=sety[posb];
                if (Math.abs(xa-xb)>res||Math.abs(ya-yb)>res)
                    continue;
                res=Math.min(res,Math.sqrt(Math.pow(xa-xb,2)+Math.pow(ya-yb,2)));
            }
        }
        String realres=Double.toString(res);
        int dotpos=realres.indexOf('.');
        if (dotpos==-1)
            realres+=".000";
        else {
            realres+="000";
            realres=realres.substring(0,dotpos+4);
        }
        System.out.println(realres);
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int cases=scanner.nextInt();
        TX_summer_0426_2 tx=new TX_summer_0426_2();
        while (cases>0){
            cases--;
            tx.getdistance(scanner);
        }
    }
}
