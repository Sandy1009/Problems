/*
https://www.geeksforgeeks.org/problems/find-if-string-is-k-palindrome-or-not1923/1
 */

public class KthPalindrome {

    public static void main(String[] ar) {
        /*int n = 8;
        int k = 1;*/
        //String str = "abcdecba";
        int n = 14;
        int k = 3;
        String str = "daccebdcdaacdc";

        System.out.println(kPalindrome(str, n, k));
    }

    private static int kPalindrome(String str, int n, int k) {

        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        int temp = find(str, sb.toString(), n, n, k);

        if(temp <= k*2) return 1;

        return 0;
    }

    private static int find(String str, String rev, int n, int m, int k) {

        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                if(i == 0) dp[i][j] = j;
                else if(j == 0) dp[i][j] = i;
                else if(str.charAt(i-1) == rev.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

}
