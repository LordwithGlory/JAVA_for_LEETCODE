import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode32 {
    public int longestValidParentheses(String s) {
        int maxlen=0;
        int startpos=Integer.MAX_VALUE;
        // 如果(多就是正的,)多就是负的
        // 对于每次负数可以考虑清零，再继续后面的操作
        // 这个对于记录开始位置似乎不咋样，所以还是使用stack比较好
//        List<Integer> balence=new ArrayList<Integer>();
//        int len=s.length();
//        for (int pos=0;pos<len;pos++){
//            if (s.charAt(pos)=='('){
//                if (pos==0||balence.indexOf(pos-1)<0){
//                    balence.add(1);
//                    continue;
//                }
//            }
//        }
        int pos=0;
        Stack<Integer> sym=new Stack<Integer>();
        for (;pos<s.length();pos++){
            if (s.charAt(pos)=='('){
                sym.push(pos);
            }else {
                if (sym.empty()){
                    startpos=Integer.MAX_VALUE;
                    continue;
                }else{
                    int former=sym.pop();
                    startpos=startpos>former?former:startpos;
                    if (sym.empty()||sym.peek()<startpos) {
                        maxlen=maxlen>(pos-startpos+1)?maxlen:(pos-startpos+1);
                    }else{
                        // ((((()(((()
                        maxlen=maxlen>(pos-sym.peek())?maxlen:(pos-sym.peek());
                    }
                }
            }
        }
        return maxlen;
    }

    public static void main(String[] args){
        Leetcode32 ltes=new Leetcode32();
        String s=new String("(()()");
        System.out.println(ltes.longestValidParentheses(s));
    }
}