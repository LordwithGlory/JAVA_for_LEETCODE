public class Leetcode42 {
    public int trap(int[] height) {
        int res=0;
        if (height.length==0)
            return 0;
        int[] leftbar=new int[height.length];
        int[] rightbar=new int[height.length];
        int pos=0;
        leftbar[0]=height[0];
        rightbar[height.length-1]=height[height.length-1];
        for (pos=1;pos<height.length;pos++){
            leftbar[pos]=height[pos]>leftbar[pos-1]?height[pos]:leftbar[pos-1];
        }
        pos=height.length-2;
        for (;pos>=0;pos--){
            rightbar[pos]=rightbar[pos+1]>height[pos]?rightbar[pos+1]:height[pos];
            int thecon=rightbar[pos]<leftbar[pos]?rightbar[pos]:leftbar[pos];
            res+=thecon-height[pos];
        }
        return res;
    }
}
