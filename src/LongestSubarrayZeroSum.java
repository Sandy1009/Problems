/*
Given an array A of N integers.
Find the length of the longest subarray in the array which sums to zero.
If there is no subarray which sums to zero then return 0.

 A = [1, -2, 1, 2]
output = 3  (1, -2, 1)
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayZeroSum {

    public static void main(String[] ar) {
        //int[] A = {1, -2, 1, 2};
        int[] A = {2, 1, -2, 1};

        int res = solve(A);
        System.out.println(res);
    }

    public static int solve(int[] A) {

        Map<Long, Integer> map = new HashMap<>();
        long sum = 0;
        int max = 0;

        for(int i=0; i<A.length; i++) {
            sum += A[i];

            if(sum ==0) {
                max = i+1;
            } else if(map.containsKey(sum)) {
                max = Math.max(max, i-map.get(sum));
            } else map.put(sum, i);
        }

        return max;

    }

}
