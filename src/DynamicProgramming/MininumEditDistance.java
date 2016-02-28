package DynamicProgramming;

public class MininumEditDistance {
    public static void main(String args[]){
        String S1 = "abcdef";
        String S2 = "azced";
        System.out.println("Minimum edit distance required is: " + edit(S1, S2));
    }

    public static int edit(String S1, String S2){

        int[][] dp = new int[S1.length()+1][S2.length()+1];
        for(int i=0; i<=S1.length();i++) {
            for (int j=0; j<=S2.length(); j++) {
                if(i==0)
                    dp[i][j] = j;
                else if(j==0)
                    dp[i][j] = i;
                else if (S1.charAt(i-1) == S2.charAt(j-1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                //System.out.print(dp[i][j] + " ");
            }
            //System.out.println();
        }

        int i = S1.length(), j = S2.length();
        while (i > 0 && j > 0)
        {
            if(dp[i][j] == Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1){
                if (dp[i][j] == dp[i-1][j-1] + 1){
                    System.out.println("Replace: " + S1.charAt(i-1) + "------>" + S2.charAt(j-1));
                    i--;
                    j--;
                } else if(dp[i][j] == dp[i][j-1] + 1){
                    System.out.println("Insert: " + S1.charAt(i-1));
                    j--;
                } else{
                    System.out.println("Delete: " + S1.charAt(i-1));
                    i--;
                }
            } else if (dp[i][j] == dp[i-1][j-1])
            {
                i--; j--;
            }
        }
        return dp[S1.length()][S2.length()];
    }
}
