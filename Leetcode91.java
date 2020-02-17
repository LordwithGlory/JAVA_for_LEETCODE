public class Leetcode91 {
    public int numDecodings(String s) {
        // 虽然是个憨皮题目但是的确有点意思。。。
        // 最快的答案是从前往后的
        int strlen=s.length();
        int[] res=new int[strlen];
        if (s.charAt(strlen-1)!='0')
            res[strlen-1]=1;
        for (int i=strlen-2;i>=0;i--){
            res[i]=res[i+1];
            if (s.charAt(i)=='0'){
                if (s.charAt(i+1)=='0')
                    return 0;
                res[i]=0;
                continue;
            }
            if (s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<'7'){
                if (i<strlen-2)
                    res[i]+=res[i+2];
                else
                    res[i]+=1;
            }else if (s.charAt(i+1)=='0')
                res[i]=0;
        }
        return res[0];
    }
}
