import java.util.Scanner;

public class Meituan_timebefore {
    public void gettime(){
        Scanner scanner=new Scanner(System.in);
        int nowday=Integer.parseInt(scanner.nextLine());
        String time=scanner.nextLine();
        int nowhour=Integer.parseInt(time.substring(0,2));
        int nowmin=Integer.parseInt(time.substring(3));
        int beforemin=scanner.nextInt();
        int hourmin=60;
        int daymin=hourmin*24;
        int weekmin=daymin*7;
        beforemin%=weekmin;
        if (beforemin>daymin){
            nowday-=beforemin/daymin;
            beforemin%=daymin;
        }
        if (beforemin>hourmin){
            nowhour-=beforemin/hourmin;
            beforemin%=hourmin;
        }
        nowmin-=beforemin;
        if (nowmin<0){
            nowmin+=60;
            nowhour-=1;
        }
        if (nowhour<0){
            nowhour+=24;
            nowday-=1;
        }
        if (nowday<=0)
            nowday+=7;
        System.out.println(nowday);
        String nowtime="";
        if (nowhour<10)
            nowtime="0";
        nowtime+=Integer.toString(nowhour);
        nowtime+=":";
        if (nowmin<10)
            nowtime+="0";
        nowtime+=Integer.toString(nowmin);
        System.out.println(nowtime);
    }

    public static void main(String[] args){
        Meituan_timebefore mt=new Meituan_timebefore();
        mt.gettime();
    }
}
