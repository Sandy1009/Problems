/*
https://www.geeksforgeeks.org/problems/minimum-cost-to-fill-given-weight-in-a-bag1956/1
 */

public class CostsToFillWeights {

    public static void main(String[] ar) {
        int n = 5;
        int w = 5;
        int[] cost = {20, 10, 4, 50, 100};

        System.out.println(minimumCost(n, w, cost));
    }

    public static int minimumCost(int n, int w, int[] cost) {

        int[] dp = new int[w + 1];
        for (int i = 1; i <= w; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= n; j++) {
                if (j <= i && cost[j - 1] != -1 && dp[i - j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - j] + cost[j - 1]);
                }
            }
        }

        return (dp[w] == Integer.MAX_VALUE) ? -1 : dp[w];
    }

}
