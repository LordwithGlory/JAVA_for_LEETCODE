import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Meituan_dpwt {
    public void get_founds(){
        Scanner scanner=new Scanner(System.in);
        int ask=scanner.nextInt();
        int sub=scanner.nextInt();
        String[] substr=new String[sub];
        Map<String,Integer> finds=new HashMap<>();
        // 对于空格进行处理
        scanner.nextLine();
        for (int pos=0;pos<sub;pos++){
            String tmp=scanner.nextLine();
            substr[pos]=tmp;
            System.out.println(tmp);
            finds.put(tmp,finds.getOrDefault(tmp,0)+1);
        }
        for (int ask_pos=0;ask_pos<ask;ask_pos++){
            String tmp=scanner.nextLine();
            if (tmp.charAt(0)=='+'){
                tmp=tmp.substring(1);
                tmp=substr[Integer.parseInt(tmp)-1];
                finds.put(tmp,finds.get(tmp)+1);
                continue;
            }else if (tmp.charAt(0)=='-'){
                tmp=tmp.substring(1);
                tmp=substr[Integer.parseInt(tmp)-1];
                finds.put(tmp,finds.get(tmp)-1);
                continue;
            }
            tmp=tmp.substring(1);
            int res=0;
            for (int pos=0;pos<sub;pos++){
                String findstr=substr[pos];
                if (finds.get(findstr)==0||findstr.length()>tmp.length())
                    continue;
                int tmpres=0;
                System.out.println(tmp);
                System.out.println(findstr);
                for (int findpos=0;findpos<=tmp.length()-findstr.length();findpos++){
                    if (tmp.charAt(findpos)!=findstr.charAt(0))
                        continue;
                    String mytmp=tmp.substring(findpos,findpos+findstr.length());
                    if (mytmp.equals(findstr))
                        tmpres++;
                }
                res+=tmpres*finds.get(findstr);
            }
            System.out.println(res);
        }
    }

    public static void main(String[] args){
        Meituan_dpwt mt=new Meituan_dpwt();
        mt.get_founds();
    }
}
