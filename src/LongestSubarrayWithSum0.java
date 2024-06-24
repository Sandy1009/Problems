import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array A of N integers.
 * Find the length of the longest subarray in the array which sums to zero.
 *
 * If there is no subarray which sums to zero then return 0.
 */
public class LongestSubarrayWithSum0 {

    public static void main(String[] ar) {

        List<Integer> A = Arrays.asList(9, -20, -11, -8, -4, 2, -12, 14, 1);

        HashMap<Long, Integer> map = new HashMap<>();
        long sum = 0;
        int max = 0;

        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);

            if (sum == 0) {
                max = i + 1;
            } else if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        System.out.println(max);
    }

}
