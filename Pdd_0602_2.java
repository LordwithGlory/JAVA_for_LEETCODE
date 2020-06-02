import java.util.Scanner;

public class Pdd_0602_2 {
    public void covertmem(){
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int[] oldmem=new int[num];
        int[] newmem=new int[num];
        int res=0;
        int newsum=0;
        for (int pos=0;pos<num;pos++){
            oldmem[pos]=scanner.nextInt();
            res+=oldmem[pos];
            newmem[pos]=scanner.nextInt();
            newsum+=newmem[pos];
        }
        for (int pos=0;pos<num;pos++){
            int tmp=newsum-newmem[pos]+oldmem[pos];
            res=Math.min(res,tmp);
            res=Math.max(res,oldmem[pos]);
        }
        System.out.println(res);
    }

    public static void main(String[] args){
        Pdd_0602_2 pdd=new Pdd_0602_2();
        pdd.covertmem();
    }
}
