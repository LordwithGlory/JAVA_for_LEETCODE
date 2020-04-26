import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TX_summer_0426_1 {
    public void likeQueue(Scanner scanner){
        int cases=scanner.nextInt();
        List<Integer> queue=new ArrayList<>();
        scanner.nextLine();
        while (cases>0){
            cases--;
            String operation=scanner.nextLine();
            int spacepos=operation.indexOf(' ');
            int num=0;
            if (spacepos!=-1){
                num=Integer.parseInt(operation.substring(spacepos+1));
                queue.add(num);
                continue;
            }
            if (operation.equals("POP")){
                if (queue.isEmpty()){
                    System.out.println("-1");
                    continue;
                }
                queue.remove(0);
            }
            else if (operation.equals("SIZE"))
                System.out.println(queue.size());
            else if (operation.equals("TOP")){
                if (queue.isEmpty()){
                    System.out.println("-1");
                    continue;
                }
                System.out.println(queue.get(0));
            }
            else if (operation.equals("CLEAR"))
                queue.clear();
        }
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int cases=scanner.nextInt();
        TX_summer_0426_1 tx=new TX_summer_0426_1();
        while (cases>0){
            cases--;
            tx.likeQueue(scanner);
        }
    }
}
