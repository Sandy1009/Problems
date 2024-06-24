import java.util.HashMap;

/*
You are given an array A of N integers and an integer B. Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.

Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.
 */
public class CountPairSum {

    public static void main(String[] ar) {

        int[] A = {16,3,3,6,7,8,17,13,7};
        int B = 3;

        int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for(int i=0; i<n; i++) {
            int diff = B - A[i];

            if(map.containsKey(diff)) count += map.get(diff);

            map.put(A[i], map.getOrDefault(A[i], 0)+1);
        }

        System.out.println(count);

    }

}
