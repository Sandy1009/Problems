/*
You are given a 2-D matrix C of size A × B.
You need to build a new 1-D array of size A by taking one element from each row of the 2-D matrix in such a way that the cost of the newly built array is minimized.
The cost of an array is the minimum possible value of the absolute difference between any two adjacent elements of the array.
So if the newly built array is X, the element picked from row 1 will become X[1], element picked from row 2 will become X[2], and so on.
Determine the minimum cost of the newly built array.

Input 1:
 A = 2
 B = 2
 C = [ [8, 4]
      [6, 8] ]

Output 1: 0
Explanation 1: Newly build array : [8, 8]. The minimum cost will be 0 since the absolute difference will be 0(8-8).

 */

import java.util.Arrays;

public class MinimumDifference {

        public static void main(String[] args) {
            int A = 2;
            int B = 2;
            int[][] C = { { 8, 4 }, { 6, 4 } };

            int result = minCostArray(A, B, C);
            System.out.println("Minimum cost of the newly built array: " + result);
        }

    public static int minCostArray(int A, int B, int[][] C) {
        int x;
        int ans = 1000000000; // Initialize answer as a large number
        int lb;
        for (int i = 0; i < A; i++) {
            Arrays.sort(C[i]); // Sort each row of matrix
        }
        for (int i = 0; i < A - 1; i++) {
            for (int j = 0; j < B; j++) {
                lb = lower_bound(C[i + 1], C[i][j]); // check for next element as in soltion
                if (lb != B) {
                    ans = Math.min(ans, Math.abs(C[i][j] - C[i + 1][lb])); // Update answer
                }
                if (lb != 0) {
                    ans = Math.min(ans, Math.abs(C[i][j] - C[i + 1][lb - 1]));
                }
            }
        }
        return ans;
    }

    // function used to find element index just greater than or equal to val
    public static int lower_bound(int a[], int val) {
        int low = 0, high = a.length - 1, ans = a.length;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (a[mid] < val) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
    }

