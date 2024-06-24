/*
Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.
A = [1, 3, 1]
output = {1,1,3}
 */
public class CountSortAlgo {

    public static void main(String[] ar) {

        int[] A = {10, 9, 8};

        int n = A.length;
        int[] res = new int[n];
        int max = 0;

        for(int i=0; i<n; i++) {
            max = Math.max(max, A[i]);
        }

        int[] count = new int[max+1];

        for(int i=0; i<n; i++) {
            count[A[i]]++;
        }

        int index = 0;
        for(int i=1; i<=max; i++) {
            for(int j=1; j<=count[i]; j++) {
                res[index++] = i;
            }
        }

        for(int i=0; i<res.length; i++) {
            System.out.print(res[i]+"   ");
        }
    }

}
