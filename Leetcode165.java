public class Leetcode165 {
    public int compareVersion(String version1, String version2) {
        // https://www.runoob.com/java/java-string-split.html方法分割
        // 最快的使用的不是interget方法，一次次进行比较
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int minres=Math.min(v1.length,v2.length);
        int pos=0;
        for (;pos<minres;pos++){
            int tmp1=Integer.parseInt(v1[pos]);
            int tmp2=Integer.parseInt(v2[pos]);
            if (tmp1>tmp2)
                return 1;
            else if (tmp1<tmp2)
                return -1;
        }
        if (v1.length==v2.length)
            return 0;
        if (v1.length>minres){
            while (pos<v1.length&&Integer.parseInt(v1[pos])==0)
                pos++;
            if (pos==v1.length)
                return 0;
            return 1;
        }
        else{
            while (pos<v2.length&&Integer.parseInt(v2[pos])==0)
                pos++;
            if (pos==v2.length)
                return 0;
            return -1;
        }
    }

    public static void main(String[] args){
        String version1="0.1";
        String version2="1.1";
        Leetcode165 lc=new Leetcode165();
        System.out.println(lc.compareVersion(version1,version2));
    }
}
