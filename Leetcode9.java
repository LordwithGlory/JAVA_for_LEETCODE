import java.util.Scanner;

// String查找子串使用indexof，对于某个位置的字符进行获取使用charat
// int转换string方法 interge.tostring  string.valueof int+""
public class Leetcode9 {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        boolean back=true;
        String xchar=String.valueOf(x);
        int len=xchar.length()-1;
        for (int pos=0;pos<=len;pos++,len--){
            if(xchar.charAt(pos)!=xchar.charAt(len)){
                back=false;
                break;
            }
        }
        return back;
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine();
        int getnum=Integer.parseInt(input);
        Leetcode9 l9=new Leetcode9();
        if(l9.isPalindrome(getnum)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
