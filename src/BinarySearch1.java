/**
 * Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.
 *
 * Return an array of size 2, such that
 *           First element = Left most index of B in A
 *           Second element = Right most index of B in A.
 * If B is not found in A, return [-1, -1].
 *
 * Note : Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Input 1:
 *  A = [5, 7, 7, 8, 8, 10]
 *  B = 8
 *
 *  Output 1: [3, 4]
 */

public class BinarySearch1 {

    public static void main(String[] ar) {

       // int[] A = { 1, 2, 6, 9, 9 };
       // int B = 2;

        int[] A = {5, 7, 7, 8, 8, 10};
        int B = 8;

        int[] res = {-1, -1};

       // if(A.length == 1 && A[0] == B) res = new int[]{0,0};

        int n = A.length;
        int l=0;
        int r = n-1;

        while(l<=r) {
            int mid = l+(r-l)/2;

            if(A[mid] == B) {
                res[0] = firstOccurrence(l, mid, A, B);
                res[1] = lastOccurrence(mid, r, A, B);
               // return res;
            }

            if(mid>=0 && A[mid] <= B) l = mid+1;
            else r = mid-1;
        }

        for(int i=0; i<2; i++) System.out.print(res[i]+"    ");
    }

    private static int firstOccurrence(int l, int r, int[] A, int B) {

        while(l<r) {
            int mid = l + (r-l)/2;
            if(A[mid] == B) r = mid;
            else l = mid+1;
        }

        return (A[l] == B) ? l : -1;
    }

    private static int lastOccurrence(int l, int r, int[] A, int B) {
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (A[mid] == B) {
                l = mid;
            } else {
                r = mid-1;
            }
        }
        return (A[l] == B) ? l : -1;
    }

}
