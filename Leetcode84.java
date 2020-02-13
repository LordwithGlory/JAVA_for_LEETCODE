public class Leetcode84 {
    public int largestRectangleArea(int[] heights) {
        int res=0;
        int[] right=new int[heights.length];
        int[] left=new int[heights.length];
        for (int i=heights.length-1;i>=0;i--){
            if (i==heights.length-1||heights[i]>heights[i+1]){
                right[i]=i;
            }else{
                int now=right[i+1];
                while (heights[now]>=heights[i]){
                    if (now==heights.length-1)
                        break;
                    if (right[now]!=now)
                        now=right[now];
                    else if (heights[now+1]>=heights[i])
                        now++;
                    else
                        break;
                }
                right[i]=now;
            }
        }
        for (int i=0;i<heights.length;i++){
            if (i==0||heights[i]>heights[i-1])
                left[i]=i;
            else {
                int now=left[i-1];
                while (heights[now]>=heights[i]){
                    if (now==0)
                        break;
                    if (left[now]!=now)
                        now=left[now];
                    else if (heights[now-1]>=heights[i])
                        now--;
                    else
                        break;
                }
                left[i]=now;
            }
            int tmp=right[i]-left[i]+1;
            tmp*=heights[i];
            res=res>tmp?res:tmp;
            System.out.println(left[i]+" "+right[i]+" "+tmp);
        }
        return res;
    }
    public static void main(String[] args){
        int[] heights={2,1,5,6,2,3};
        Leetcode84 lc=new Leetcode84();
        System.out.println(lc.largestRectangleArea(heights));
    }
}
