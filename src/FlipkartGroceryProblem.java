/*
https://www.scaler.com/academy/mentee-dashboard/class/176829/assignment/problems/9294?navref=cl_tt_lst_nm
 */

import java.util.PriorityQueue;
import java.util.Queue;

public class FlipkartGroceryProblem {

    static class T {
        int exp;
        int prof;

        T(int a, int b) {
            exp = a;
            prof = b;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 7, 6, 2, 8, 4, 4, 6, 8, 2};
        int[] B = {8, 11, 7, 7, 10, 8, 7, 5, 4, 9};
        System.out.println(solve(A, B)); // Expected output: 65
    }

    public static int solve(int[] A, int[] B) {

        Queue<T> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.exp != b.exp) {
                return Integer.compare(a.exp, b.exp);
            } else {
                return Integer.compare(b.prof, a.prof);
            }
        });
        Queue<T> maxHeap = new PriorityQueue<>((a, b) -> b.prof - a.prof);

        for (int i = 0; i < A.length; i++) {
            minHeap.add(new T(A[i], B[i]));
        }

        int res = 0;
        int t = 0;

        while (!minHeap.isEmpty() || !maxHeap.isEmpty()) {
            while (!minHeap.isEmpty() && minHeap.peek().exp <= t + 1) {
                maxHeap.add(minHeap.poll());
            }

            if (!maxHeap.isEmpty()) {
                res += maxHeap.poll().prof;
                t++;
            } else {
                if (!minHeap.isEmpty()) {
                    t = minHeap.peek().exp - 1;
                }
            }
        }

        return res;
    }

}
