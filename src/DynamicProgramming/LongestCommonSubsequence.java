package DynamicProgramming;

//import java.util.Scanner;

/**
 * Prints the Longest Common Sub sequence and its Length
 */
public class LongestCommonSubsequence {
    public static void main(String args[]){
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Please enter String1: ");
        //String S1 = sc.nextLine();
        //System.out.println("Please enter String2; ");
        //String S2 = sc.nextLine();
        String S1 = "abcdaf";
        String S2 = "acbcf";

        System.out.println("Longest Common Subsequence: " +LCS(S1, S2));
        System.out.println("Length of Longest Common Subsequence: " +LCS(S1, S2).length());

    }

    public static String LCS(String S1, String S2){
        int[][] dp = new int[S1.length() + 1][S2.length() + 1];

        for(int i=0; i<=S1.length(); i++){
            for(int j=0; j<=S2.length(); j++){
                if(i==0 | j==0){
                    dp[i][j] = 0;
                } else if(S1.charAt(i-1) == S2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = S1.length(), j = S2.length();
        while (i > 0 && j > 0)
        {
            if (S1.charAt(i-1) == S2.charAt(j-1))
            {
                sb.append(S1.charAt(i-1));
                i--; j--;
            }
            else if (dp[i-1][j] > dp[i][j-1])
                i--;
            else
                j--;
        }
        return sb.reverse().toString();
    }
}
