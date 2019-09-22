import java.util.*;

public class Leetcode20 {
    public List<String> generateParenthesis(int n) {
        // 这个是一个节省了空间但是超级耗时的憨批操作==
        // 基本思想DFS，md DFS好长时间没用想起来就是递归，然后终于写了一个发现把stack写成了queue
        List<String> res=new ArrayList<String>();
        Stack<Character> q= new Stack<Character>();
        q.add('(');
        int left,right;
        left=1;
        right=0;
        while (q.size()!=0){
            if(left<n){
                // queue add 对于异常处理不完备
                // stack add 可还行
                q.add('(');
                left++;
            }else if(right<n){
                q.add(')');
                right++;
            }
            if(right==n&&left==n){
                String tmpstr=new String();
                for(Character x:q){
                    tmpstr+=x.toString();
                }
                res.add(tmpstr);
            }
            if(right>left||right==n&&left==n){
                while (true){
                    char tmp=q.pop();
                    while (tmp==')'){
                        right--;
                        tmp=q.pop();
                    }
                    if(q.isEmpty()){
                        return res;
                    }
                    left--;
                    if(right<left){
                        // 在这个地方忘记要直接加上右括号然后有问题
                        q.add(')');
                        right++;
                        break;
                    }
                }

            }
        }
        return res;
    }

    public static void main(String argvs[]){
        Queue<Character>l=new LinkedList<Character>();
        l.offer('a');
        l.offer('b');
        System.out.println(l.toString());
        Leetcode20 lt=new Leetcode20();
        System.out.println(lt.generateParenthesis(3));
    }
}
