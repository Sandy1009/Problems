/**
 * find the second largest element from the array
 */

package LLoydsInterviewQuestions;

import java.util.PriorityQueue;

public class SecondLargestElement {

    public static void main(String[] args) {
        int[] ar = {10, 67, 893, 34, 99};
        int k = 2;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        for(int i : ar) pq.add(i);

        int res = -1;

        for(int i=0; i<k; i++) {
            res = pq.poll();
        }

        System.out.println(res);
    }

}
