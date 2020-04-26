import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TX_summer_0426_4 {
    public void getstack(){
        Scanner scanner=new Scanner(System.in);
        int cases=scanner.nextInt();
        List<Integer> stack=new ArrayList<>();
        scanner.nextLine();
        while (cases>0){
            cases--;
            String operation=scanner.nextLine();
            int spacepos=operation.indexOf(' ');
            if (spacepos!=-1){
                spacepos=Integer.parseInt(operation.substring(spacepos+1));
                stack.add(spacepos);
                continue;
            }
            if (operation.equals("peek"))
                System.out.println(stack.get(0));
            else if (operation.equals("poll"))
                stack.remove(0);
        }
    }

    public static void main(String[] args){
        TX_summer_0426_4 tx=new TX_summer_0426_4();
        tx.getstack();
    }
}
