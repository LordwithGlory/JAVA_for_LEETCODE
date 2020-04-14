public class Leetcode73 {
    public int minDistance(String word1, String word2) {
        // 运用dp思路 将一个编辑距离和附近的编辑距离连接起来
        int len_w1=word1.length();
        int len_w2=word2.length();
        int[][] dp=new int[len_w1+1][len_w2+1];
        // 刚才少了一个等于号
        for (int pos=0;pos<=len_w1;pos++)
            dp[pos][0]=pos;
        for (int pos=0;pos<=len_w2;pos++)
            dp[0][pos]=pos;
        for (int row=1;row<len_w1+1;row++){
            for (int col=1;col<len_w2+1;col++){
                // 如果是符合左侧或者上侧的说明至少有一个delete或者insert
                dp[row][col]=Math.min(dp[row-1][col],dp[row][col-1])+1;
                int addone=0;
                if (word1.charAt(row-1)!=word2.charAt(col-1))
                    addone=1;
                dp[row][col]=Math.min(dp[row][col],dp[row-1][col-1]+addone);
            }
        }
        return dp[len_w1][len_w2];
    }
}
