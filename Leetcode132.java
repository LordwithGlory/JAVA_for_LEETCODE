public class Leetcode132 {
    public int mycut(char[] thec,int left,int right,int[] cut){
        if (cut[left]!=0)
            return cut[left];
        for (int pos=right;pos>=left;pos--){
            if (thec[pos]==thec[left]){
                int l=left;
                int r=pos;
                boolean iscut=true;
                while (l<r){
                    if (thec[l]==thec[r]){
                        l++;
                        r--;
                        continue;
                    }
                    iscut=false;
                    break;
                }
                if (iscut){
                    int tmp=1;
                    if (pos!=right)
                        tmp+=mycut(thec,pos+1,right,cut);
                    if (cut[left]==0||cut[left]>tmp)
                        cut[left]=tmp;
                }
                if (cut[left]==1)
                    return 1;
            }
        }
        return cut[left];
    }
    public int minCut(String s) {
        int slen=s.length();
        if (slen==0)
            return 0;
        char[] schar=s.toCharArray();
        int[] cut=new int[slen];
        mycut(schar,0,slen-1,cut);
        return cut[0]-1;
    }

    public static void main(String[] args){
        String s=new String("abbab");
        Leetcode132 lc=new Leetcode132();
        System.out.println(lc.minCut(s));
    }
}
