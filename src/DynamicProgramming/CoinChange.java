package DynamicProgramming;

public class CoinChange {
    public static void main(String args[]){
        int[] coins = new int[]{1, 2, 3};
        int sum = 5;
        System.out.println("Total number : " + coinCount(coins, sum));
    }

    public static int coinCount(int[] coins, int sum){
        int[][] dp = new int[coins.length][sum+1];

        for(int i=0; i<coins.length; i++){
            for(int j=0; j<=sum; j++){
                if(i==0)
                    dp[i][j]=1;
                else if(j >= coins[i])
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                else
                    dp[i][j] = dp[i-1][j];
            //System.out.print(dp[i][j] + " ");
            }
        //System.out.println();
        }
        return dp[coins.length-1][sum];
    }
}
