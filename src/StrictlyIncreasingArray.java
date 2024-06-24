import java.util.Arrays;

/*
Given an array nums of n positive integers. Find the minimum number of operations required to modify the array such that array elements are in strictly increasing order (nums[i] < nums[i+1]).
Changing a number to greater or lesser than original number is counted as one operation.
Note: Array elements can become negative after applying operation.

Input:
n = 6
nums = [1, 2, 3, 6, 5, 4]
Output:  2
Explanation:
By decreasing 6 by 2 and increasing 4 by 2, nums will be like [1, 2, 3, 4, 5, 6] which is stricly increasing.
 */
public class StrictlyIncreasingArray {

    public static void main(String[] ar) {

        int[] A = {1,2,3,6,5,4};

        int n = A.length;
        int temp = 1;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(A[i]-A[j] >= i-j) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    temp = Math.max(temp, dp[i]);
                }
            }
        }

        System.out.println(n-temp);
    }

}
