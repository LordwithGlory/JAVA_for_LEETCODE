public class Leetcode48 {
    public void rotate(int[][] matrix) {
        int lens=matrix[0].length;
        int[][] tmpmat=new int[lens][lens];
        for (int tmp=0,row=lens-1;tmp<lens&&row>=0;tmp++,row--){
            for (int i=0;i<lens;i++){
                tmpmat[i][tmp]=matrix[row][i];
            }
        }
        for (int i=0;i<lens;i++){
            for (int j=0;j<lens;j++){
                matrix[i][j]=tmpmat[i][j];
            }
        }
    }
}
