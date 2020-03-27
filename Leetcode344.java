public class Leetcode344 {
    public void reverseString(char[] s) {
        if (s==null||s.length==0)
            return;
        int right=s.length-1;
        int left=0;
        while (left<right){
            char tmp=s[left];
            s[left]=s[right];
            s[right]=tmp;
            left++;
            right--;
        }
    }
}
