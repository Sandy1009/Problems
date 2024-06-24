/*
Reverse a linked list A from position B to C.
NOTE: Do it in-place and in one-pass.

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 2
 C = 4

 output =  1 -> 4 -> 3 -> 2 -> 5
 */

public class ReverseLinkedListFromGivenPositions {

    public static void main(String[] ar) {
        ListNode A = new ListNode(1);
     //   A.next = new ListNode(2);
       // A.next.next = new ListNode(3);
      //  A.next.next.next = new ListNode(4);
       // A.next.next.next.next = new ListNode(5);

      //  int B = 2;
       // int C = 4;
        //int C = 3;
        int B = 1;
        int C = 1;

        ListNode result = reverseBetween(A, B, C);

        // Print the result of adding the two numbers
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }
    }

    public static ListNode reverseBetween(ListNode A, int B, int C) {

        ListNode h1 = A;
        ListNode temp = null;
        ListNode h2 = null;
        ListNode h3 = null;

        int count = 1;
        while(temp != null && count < B) {
            h1 = temp;
            temp = temp.next;
            count++;
        }

        h2 = temp;
        ListNode h2temp = h2;

        while(h2temp != null && count < C) {
            h2temp = h2temp.next;
            count++;
        }

        if(h2temp != null) h3 = h2temp.next;

        h2temp.next = null;

        h2 = reverse(h2);

        h1.next = h2;
        if(h3 != null) {
            while(h1 != null && h1.next != null) h1 = h1.next;
            h1.next = h3;
        }

        return A;

    }

    private static ListNode reverse(ListNode root) {
        ListNode prev = null;
        ListNode curr = root;
        ListNode next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

}
