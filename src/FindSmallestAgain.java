/*
Given an integer array A of size N.
If we store the sum of each triplet of the array A in a new list, then find the Bth smallest element among the list.
NOTE: A triplet consists of three elements from the array. Let's say if A[i], A[j], A[k] are the elements of the triplet then i < j < k.

Input 1:
 A = [2, 4, 3, 2]
 B = 3

Output 1:  9

Explanation 1:
 All the triplets of the array A are:
 (2, 4, 3) = 9
 (2, 4, 2) = 8
 (2, 3, 2) = 7
 (4, 3, 2) = 9

 So the 3rd smallest element is 9.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindSmallestAgain {

    public static void main(String[] ar) {
       // ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 4, 3, 2));
        // int B = 3;
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 5, 7, 3, 2));
       int B = 9;
        int result = solve(A, B);
        System.out.println("Output: " + result);
    }

    public static int solve(ArrayList<Integer> A, int B) {
        // Sort the array to use binary search
        Collections.sort(A);
        int low = 0;
        int high = A.get(A.size() - 1) * 3; // Maximum possible sum of a triplet
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countTriplets(A, mid);

            if (count >= B) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static int countTriplets(ArrayList<Integer> A, int target) {
        int count = 0;
        int n = A.size();

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = A.get(i) + A.get(left) + A.get(right);
                if (sum <= target) {
                    count += right - left; // Count all triplets between left and right
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }

}
