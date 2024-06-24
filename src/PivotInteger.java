/*
Given a positive integer n, find the pivot integer x such that:
The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most one pivot index for the given input.

Example 1:
Input: n = 8
Output: 6
Explanation: 6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21.
 */
public class PivotInteger {

    public static void main(String[] ar) {

        int n = 8;

        if (n == 1)  {
            System.out.println(1);
            System.exit(0);
        }

        int totalSum = (n * (n + 1)) / 2;
        int leftSum = 0;

        for (int x = 1; x <= n; x++) {
            leftSum += x;
            int rightSum = totalSum - leftSum + x;
            if (leftSum == rightSum) {
                System.out.println(x);
            }
        }

        System.out.println(-1);

    }

}
