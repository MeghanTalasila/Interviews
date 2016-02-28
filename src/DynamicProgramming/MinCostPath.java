package DynamicProgramming;

public class MinCostPath {
    public static void main(String args[]){
        int[][] cost= new int[][]{{1, 2, 3},
                                  {4, 8, 2},
                                  {1, 5, 3} };
        System.out.println("Minimum cost to reach: "+ minCost(cost, 2, 2));
    }

    public static int minCost(int[][] cost, int m, int n){

       if(m<0 || n<0)
           return 0;
       else if (m == 0 && n == 0)
            return cost[m][n];
        else
            return cost[m][n] + Math.min(Math.min(minCost(cost, m-1, n-1),
                    minCost(cost, m-1, n)),
                    minCost(cost, m, n-1));
    }
}
