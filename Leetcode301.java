import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode301 {
    public void getresutl(char[] c_array,Stack<Integer> former,Stack<Integer> backer,int beginpos,int endpos,List<String> res){
        if (former.size()==0&&backer.size()==0){
            String onestr=new String();
            for (char c:c_array){
                if (c==0)
                    continue;
                onestr+=c;
            }
            if (!res.contains(onestr))
                res.add(onestr);
            return;
        }
        if (former.size()!=0){
            int nowpos=former.pop();
            for (int pos=endpos-1;pos>=nowpos;pos--){
                if (c_array[pos]=='('){
                    c_array[pos]=0;
                    getresutl(c_array,former,backer,beginpos,pos,res);
                    c_array[pos]='(';
                }
            }
            former.add(nowpos);
        }
        if (backer.size()!=0){
            int nowpos=backer.remove(0);
            for (int pos=beginpos+1;pos<=nowpos;pos++){
                if (c_array[pos]==')'){
                    c_array[pos]=0;
                    getresutl(c_array,former,backer,pos,endpos,res);
                    c_array[pos]=')';
                }
            }
            backer.add(0,nowpos);
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList<>();
        if (s==null)
            return res;
        Stack<Integer> formrpos=new Stack<>();
        Stack<Integer> backrpos=new Stack<>();
        for (int pos=0;pos<s.length();pos++){
            if (s.charAt(pos)=='(')
                formrpos.push(pos);
            else if (s.charAt(pos)==')'){
                if (formrpos.isEmpty()){
                    backrpos.add(pos);
                    continue;
                }
                formrpos.pop();
            }
        }
        if (formrpos.size()+backrpos.size()==0){
            res.add(s);
            return res;
        }
        char[] char_array=s.toCharArray();
        getresutl(char_array,formrpos,backrpos,-1,s.length(),res);
        return res;
    }

    public static void main(String[] args){
        Leetcode301 lc=new Leetcode301();
        lc.removeInvalidParentheses("((()");
    }
}
