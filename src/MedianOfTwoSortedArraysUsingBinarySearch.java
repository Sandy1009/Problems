/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Leetcode 4
 */

public class MedianOfTwoSortedArraysUsingBinarySearch {

    public static void main(String[] ar) {
        int[] ar1 = {1, 2, 4, 6, 10};
        int[] ar2 = {4, 5, 6, 9, 12};

        int res = binary(ar1, ar2);
        System.out.println(res);
    }

    private static int binary(int[] ar1, int[] ar2) {
        int n = ar1.length;
        int m = ar2.length;

        if(n > m) return binary(ar2, ar1);
        int low = 0;
        int high = n;

        while(low <= high) {
            int m1 = (low+high)/2;
            int m2 = (n+m+1)/2 - m1;

            int l1 = (m1 == 0) ? Integer.MIN_VALUE : ar1[m1-1];
            int l2 = (m2 == 0) ? Integer.MIN_VALUE : ar2[m2-1];
            int r1 = (m1 == n) ? Integer.MAX_VALUE : ar1[m1];
            int r2 = (m2 == m) ? Integer.MAX_VALUE : ar2[m2];

            if(l1 <= r2 && l2 <= r1) {
                if((n+m) % 2 == 1) return Math.max(l1, l2);
                else {
                    return Math.max(l1, l2) + Math.min(r1, r2);
                }
            } else if(l1 > r2) high = m1 -1;
            else low = m1+1;
        }

        return -1;
    }

}
