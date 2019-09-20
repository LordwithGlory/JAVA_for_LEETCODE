import java.io.BufferedReader;
import java.io.InputStreamReader;

// JAVA输入部分：用bufferreader或scanner，https://www.cnblogs.com/SzBlog/p/5404246.html，有时候每次只能读取一个字节
// Java中string和int之间的互相转换操作，依靠int的相关方法toString和parseInt
// main函数的处理
public class Leetcode7 {
    public int solution(int x){
        long back=0;
        while(x!=0){
            back*=10;
            back+=x%10;
            x/=10;
        }
        if(back>Integer.MAX_VALUE||back<Integer.MIN_VALUE){
            back=0;
        }
        return (int)back;
    }
    public static void main(String[] args){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int read=0;
        String input=null;
        try {
            input=br.readLine();
            read=Integer.parseInt(input);
            System.out.println(read);
        }catch (Exception o){
            System.out.println(o.getMessage());
        }
        Leetcode7 l7=new Leetcode7();
        System.out.println(l7.solution(read));
    }
}
