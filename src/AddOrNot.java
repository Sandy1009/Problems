/*
Given an array of integers A of size N and an integer B.
In a single operation, any one element of the array can be increased by 1. You are allowed to do at most B such operations.
Find the number with the maximum number of occurrences and return an array C of size 2, where C[0] is the number of occurrences,
and C[1] is the number with maximum occurrence.
If there are several such numbers, your task is to find the minimum one.

Input 1:
 A = [3, 1, 2, 2, 1]
 B = 3

Output 1:  [4, 2]

Explanation 1:
Apply operations on A[2] and A[4]
 A = [3, 2, 2, 2, 2]
 Maximum occurrence =  4
 Minimum value of element with maximum occurence = 2
 */

import java.util.Arrays;

public class AddOrNot {

    public static void main(String[] args) {
        //ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 1));
        int[] A = {3,1,2,2,1};
        int B = 3;
        /*ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 5, 5));
        int B = 3;*/
        int[] result = solve(A, B);
        System.out.println("Output: " + result[0]+"   "+result[1]);
    }

    public static int[] solve(int[] A, int B) {
        long prefix[] = new long[A.length + 1];
        Arrays.sort(A);
        int n = A.length;
        // Make prefix array
        for (int i = 0; i < n; i++) {
            prefix[i + 1] += A[i] + prefix[i];
        }
        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        for (int i = 0; i < n; i++) {
            int lo = 1, hi = i + 1;
            int mx = 0;
            // Binary search to find the value of cnt for each i
            while (lo <= hi) {
                int cnt = (lo + hi) / 2;
                if ((long) A[i] * cnt - (prefix[i + 1] - prefix[i - cnt + 1]) <= B) {
                    mx = cnt;
                    lo = cnt + 1;
                } else {
                    hi = cnt - 1;
                }
            }
            // Update ans
            if (ans[0] < mx) {
                ans[0] = mx;
                ans[1] = A[i];
            }
        }
        return ans;
    }

}
