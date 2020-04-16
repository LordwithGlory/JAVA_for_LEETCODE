import java.util.Scanner;

public class Ali_0415_zsjs {
    public double getmax(int[] reader,int[] interpreter,int lens){
        double res=0;
        for (int num=0;num<lens;num++){
            int myreadr=reader[num];
            int myinter=interpreter[num];
            for (int next=num+1;next<lens;next++){
                double tmp=Math.min((myinter+interpreter[next])/2.0,(myreadr+reader[next])/2.0);
                res=Math.max(tmp,res);
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int cases=scanner.nextInt();
        int[] reader=new int[cases];
        int[] inter=new int[cases];
        for (int pos=0;pos<cases;pos++){
            reader[pos]=scanner.nextInt();
            inter[pos]=scanner.nextInt();
        }
        Ali_0415_zsjs ali=new Ali_0415_zsjs();
        System.out.println(ali.getmax(reader,inter,cases));
    }
}
