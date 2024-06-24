/*
Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

Return the ans % 10000003.

Input 1:
 A = 2
 B = 5
 C = [1, 10]

Output 1:  50

Explanation 1:
 Possibility 1:- One painter paints both blocks, time taken = 55 units.
 Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
 There are no other distinct ways to paint boards.
 ans = 50 % 10000003
 */

import java.util.ArrayList;
import java.util.Arrays;

public class PaintersPartitionProblem {

    public static void main(String[] ar) {
        int A = 4;
        int B = 10;
        //int[] C = { 884, 228, 442, 889 };
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(884, 228, 442, 889));
        /*int A = 10;
        int B = 1;
        int C[] = {1, 8, 11, 3};*/
        /*int C[] = {1000000,1000000};
        int A = 1;
        int B = 1000000;*/
        int result = paint(A, B, C);
        System.out.println(result);
    }
    private static final int MOD = 10000003;

    public static int paint(int A, int B, ArrayList < Integer > C) {

        long res = Long.MAX_VALUE;
        long low = 0;
        long high = Long.MAX_VALUE;
        long mid;

        while (low <= high) {
            mid = low + ((high - low) >> 1);
            boolean status = possible(A, B, C, mid);
            if (status) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)(res % MOD);
    }

    private static boolean possible(int A, int B, ArrayList< Integer > C, long time) {
        int n = C.size();
        int index = 0;
        long total;

        for (int i = 0; i < A && index < n; i++) {
            total = 0;
            while (total < time && index < n) {
                total += (1L * C.get(index) * B);
                if (total > time)
                    break;
                index++;
            }
        }
        if (index != n)
            return false;
        return true;
    }


}
