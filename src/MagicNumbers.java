/**
 * in a given array, find the number that highest number of prime factors
 */

import java.util.Arrays;

public class MagicNumbers {

    public static void main(String[] ar) {

        int[] A = {36,13,13,26, 37, 28, 27, 43, 7};
        int max = Arrays.stream(A).max().getAsInt();
        int[] primeCount = countPrimeFactors(max);

        int maxPrimeCount = 0;
        int result = 0;

        for (int num : A) {
            int count = primeCount[num];
            if (count > maxPrimeCount || (count == maxPrimeCount && num > result)) {
                maxPrimeCount = count;
                result = num;
            }
        }

        System.out.println(result);
    }

    private static int[] countPrimeFactors(int x) {
        int[] primeCount = new int[x + 1];
        Arrays.fill(primeCount, 0);

        for (int i = 2; i <= x; i++) {
            if (primeCount[i] == 0) {
                for (int j = i; j <= x; j += i) {
                    primeCount[j]++;
                }
            }
        }

        return primeCount;
    }

}
