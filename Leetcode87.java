public class Leetcode87 {
    public boolean isScramb(String s1,String s2){
        // 最快的那个分别对于从前从后两种形式进行计算
        // 用Arrays.equals方法比较两个数组是否相同
        if (s1.equals(s2))
            return true;
        int[] count=new int[26];
        for (int pos=0;pos<s1.length();pos++)
            count[s1.charAt(pos)-'a']++;
        for (int pos=0;pos<s2.length();pos++)
            count[s2.charAt(pos)-'a']--;
        for (int tmp:count){
            if (tmp!=0)
                return false;
        }
        if (s1.length()==2&&s1.charAt(0)==s2.charAt(1)&&s1.charAt(1)==s2.charAt(0))
            return true;
        for (int pos=1;pos<s1.length();pos++){
            String s_l=s1.substring(0,pos);
            String s_r=s1.substring(pos);
            String a_l=s2.substring(0,pos);
            String a_r=s2.substring(pos);
            String b_l=s2.substring(0,s1.length()-pos);
            String b_r=s2.substring(s1.length()-pos);
            if (isScramb(s_l,a_l)&&isScramb(s_r,a_r)||isScramb(s_l,b_r)&&isScramb(s_r,b_l))
                return true;
        }
        return false;
    }
//    public boolean isScramble(String s1, String s2) {
//        if (s1.length()!=s2.length())
//            return false;
//        else if (s1==null||s1.length()==0)
//            return true;
//        int left=0;
//        int right=s1.length()-1;
//        while (left<=right){
//            if (s1.charAt(left)!=s2.charAt(left))
//                break;
//            left++;
//        }
//        while (right>=left){
//            if (s1.charAt(right)!=s2.charAt(right))
//                break;
//            right--;
//        }
//        if (left>right){
//            return true;
//        }
//        else {
//            String tmp1=s1.substring(left,right+1);
//            String tmp2=s2.substring(left,right+1);
//            String tmp3=new StringBuffer(tmp2).reverse().toString();
//            if (tmp1.equals(tmp3))
//                return true;
//            else
//                return isScramb(tmp1,tmp2);
//        }
//    }

    public static void main(String[] args){
        String a=new String("abcd");
        String b=new String("badc");
        Leetcode87 lc=new Leetcode87();
        System.out.println(lc.isScramb(a,b));
    }
}
