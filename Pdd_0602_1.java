import java.util.Scanner;

public class Pdd_0602_1 {
    public void getthek(){
        Scanner scanner=new Scanner(System.in);
        int cases=scanner.nextInt();
        while (cases>0){
            cases--;
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            int base=n-1;
            int mul=k/base;
            int mod=k%base;
            if (mod==0){
                mul-=1;
                mod=base;
            }
            System.out.println(n*mul+mod);
        }
    }

    public static void main(String[] args){
        Pdd_0602_1 pdd=new Pdd_0602_1();
        pdd.getthek();
    }

}
