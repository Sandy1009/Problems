/*
You are given two linked lists, A and B, representing two non-negative numbers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return it as a linked list.
 */

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class AddTwoLinkedLists {

    public static void main(String[] ar) {
        ListNode A = new ListNode(4);
        A.next = new ListNode(5);
       // A.next.next = new ListNode(3);

        // Create ListNode for list B: [5, 6, 4]
        ListNode B = new ListNode(3);
        B.next = new ListNode(4);
        B.next.next = new ListNode(5);

        // Create an instance of Solution class to perform addition
        ListNode result = addTwoNumbers(A, B);

        // Print the result of adding the two numbers
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode num1, ListNode num2) {

      /*  int carry = 0;
        ListNode head = new ListNode('\0');
        ListNode temp = head;

        while(A != null && B != null) {
            int sum = A.val + B.val + carry;
            int rem = sum%10;
            carry = sum/10;

            temp.next = new ListNode(rem);
            temp = temp.next;
            A = A.next;
            B = B.next;
        }

        while(A != null) {
            int sum = A.val + carry;
            int rem = sum%10;
            carry = sum/10;

            temp.next = new ListNode(rem);
            temp = temp.next;
            A = A.next;
        }

        while(B != null) {
            int sum = B.val + carry;
            int rem = sum%10;
            carry = sum/10;

            temp.next = new ListNode(rem);
            temp = temp.next;
            B = B.next;
        }

        if(carry != 0) temp.next = new ListNode(carry);

        return head.next; */

        if(num1 == null && num2 == null) return null;
        if(num1 == null) return num2;
        if(num2 == null) return num1;

        while (num1 != null && num1.val == 0)
            num1 = num1.next;

        while (num2 != null && num2.val == 0)
            num2 = num2.next;

        if (num1 == null)  return num2;
        if (num2 == null)  return num1;

        num1 = reverse(num1);
        num2 = reverse(num2);

        int carry = 0;
        ListNode sumNode = new ListNode('\0');
        ListNode head = sumNode;

        while(num1 != null && num2 != null) {
            int sum = num1.val + num2.val + carry;
            int rem = sum % 10;
            carry = sum/10;

            ListNode temp = new ListNode(rem);
            sumNode.next = temp;
            sumNode = sumNode.next;

            num1 = num1.next;
            num2 = num2.next;
        }

        while(num1 != null) {
            int sum = num1.val + carry;
            int rem = sum%10;
            carry = sum/10;

            ListNode temp = new ListNode(rem);
            sumNode.next = temp;
            sumNode = sumNode.next;

            num1 = num1.next;
        }

        while(num2 != null) {
            int sum = num2.val + carry;
            int rem = sum%10;
            carry = sum/10;

            ListNode temp = new ListNode(rem);
            sumNode.next = temp;
            sumNode = sumNode.next;

            num2 = num2.next;
        }

        if(carry != 0) {
            ListNode temp = new ListNode(carry);
            sumNode.next = temp;
            sumNode = sumNode.next;
        }

        head = reverse(head.next);

        return head;

    }

    private static ListNode reverse(ListNode root) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = root;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

}
