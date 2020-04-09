import java.util.Scanner;

public class Acmcoder_dp_jxdl {
    public void out_num(int num){
       boolean[] res=new boolean[num];
       int mylen=num;
       while (mylen>3){
           int nowpos=0;
           for (int pos=0;pos<num;pos++){
               if (res[pos])
                   continue;
               nowpos++;
               if (nowpos%2==0){
                   res[pos]=true;
                   mylen--;
               }
           }
           if (mylen<4)
               break;
           nowpos=0;
           for (int pos=0;pos<num;pos++){
               if (res[pos])
                   continue;
               nowpos++;
               if (nowpos%3==0){
                   res[pos]=true;
                   mylen--;
               }
           }
       }
       for (int pos=0;pos<num;pos++){
           if (res[pos])
               continue;
           System.out.print(pos+1);
           mylen--;
           if (mylen!=0)
               System.out.print(" ");
       }
    }

    public static void main(String[] args){
        Acmcoder_dp_jxdl acd=new Acmcoder_dp_jxdl();
        Scanner scanner=new Scanner(System.in);
        int cases=scanner.nextInt();
        while (cases>0){
            acd.out_num(scanner.nextInt());
            System.out.println();
            cases--;
        }
    }
}
