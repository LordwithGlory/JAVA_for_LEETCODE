public class Leetcode69 {
    public int mySqrt(int x) {
        if (x==1)
            return x;
        int left=0;
        int right=x;
        while (left<right){
            int mid=(left+right)/2;
            if (x/mid<mid){
                right=mid-1;
            }else if (x/mid>mid){
                if (left==mid){
                    if (right*right>x){
                        return left;
                    }else
                        return right;
                }
                left=mid;
            }else
                return mid;
        }
        return right;
    }
}
