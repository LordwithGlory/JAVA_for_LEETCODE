public class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowlen=matrix.length;
        if (rowlen==0)
            return false;
        int collen=matrix[0].length;
        if (collen==0)
            return false;
        for (int rownum=0;rownum<rowlen;rownum++){
            if (matrix[rownum][0]>target){
                break;
            }else if (matrix[rownum][collen-1]<target)
                continue;
            int left=0;
            int right=collen-1;
            while (left<=right){
                int mid=(left+right)/2;
                if (matrix[rownum][mid]==target)
                    return true;
                if (matrix[rownum][mid]>target){
                    right=mid-1;
                    continue;
                }else {
                    left=mid+1;
                }
            }
        }
        return false;
    }
}
