public class Leetcode877 {
    public int findmax(int[][] dp,int[] piles,int left,int right){
        if (left>=piles.length||right<0||left>right)
            return 0;
        if (dp[left][right]!=0)
            return dp[left][right];
        int getleft=piles[left]+Math.max(findmax(dp,piles,left+2,right),findmax(dp,piles,left+1,right-1));
        int getright=piles[right]+Math.max(findmax(dp,piles,left,right-2),findmax(dp,piles,left+1,right-1));
        dp[left][right]=Math.max(getleft,getright);
        return dp[left][right];
    }
    public boolean stoneGame(int[] piles) {
        // 有个比较快的有点意思是先排序然后轮流拿 不过这特么你能每次拿到最大的么
        // 合情合理还比较快的那个是在findmax里面添加了sum1，sum2分别技术
        // 最后比较大小
        // 这什么沙雕题目。。。就我们可以顺序对调。。。所以先手一定赢
        int[][] dp=new int[piles.length][piles.length];
        int left=0;
        int right=piles.length-1;
        int sum=0;
        for (int pos=0;pos<piles.length;pos++){
            sum+=piles[pos];
            dp[pos][pos]=piles[pos];
        }
        int res=findmax(dp,piles,left,right);
        if (res*2>sum)
            return true;
        return false;
    }
}
