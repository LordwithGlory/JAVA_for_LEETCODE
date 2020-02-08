public class Leetcode72 {
    public void setZeroes(int[][] matrix) {
        int rowlen=matrix.length;
        int collen=matrix[0].length;
        // 标记某一行有0
        boolean[] rows=new boolean[rowlen];
        // 标记某一列有0
        boolean[] cols=new boolean[collen];
        for (int rownum=0;rownum<rowlen;rownum++){
            for (int colnum=0;colnum<collen;colnum++){
                if (matrix[rownum][colnum]==0){
                    rows[rownum]=true;
                    cols[colnum]=true;
                }
            }
        }
        for (int rownum=0;rownum<rowlen;rownum++){
            for (int colnum=0;colnum<collen;colnum++){
                if (rows[rownum]||cols[colnum])
                    matrix[rownum][colnum]=0;
            }
        }
        return;
    }
}
