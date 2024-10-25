package NewRealic;

import java.util.Arrays;

public class BobArray {

    public int solve(int[] arr, int k) {
        int n = arr.length;

        // Edge case: If the array has 0 or 1 element
        if (n <= 1) {
            return 0;
        }

        // Calculate differences between consecutive elements
        int[] diffs = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diffs[i] = Math.abs(arr[i + 1] - arr[i]);
        }

        // If k is greater than or equal to n - 1, we can reduce all differences to zero
        if (k >= n - 1) {
            return 0;
        }

        // Sort differences in ascending order
        Arrays.sort(diffs);

        for (int i = 0; i < (n - 1) / 2; i++) {
            int temp = diffs[i];
            diffs[i] = diffs[n - 2 - i];
            diffs[n - 2 - i] = temp;
        }

        // Reduce the largest k differences
        for (int i = 0; i < k; i++) {
            diffs[n - 2 - i] = 0;
        }

        // Find the maximum of the remaining differences
        int maxDiff = 0;
        for (int diff : diffs) {
            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        BobArray solver = new BobArray();

        // Test case 1
        int input1 = 5;
        int input2 = 2;
        int[] input3 = {4, 7, 4, 7, 4};
        System.out.println(solver.solve(input3, input2)); // Expected output: 0

        // Test case 2
        input1 = 6;
        input2 = 3;
        int[] input4 = {1, 2, 3, 7, 8, 9};
        System.out.println(solver.solve(input4, input2)); // Expected output: 1
    }
}

