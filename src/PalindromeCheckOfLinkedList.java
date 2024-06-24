public class PalindromeCheckOfLinkedList {

    public static void main(String[] ar) {
        Node A = new Node(8);
        A.next = new Node(1);

        int result = checkPalindrome(A);

        System.out.println(result);
    }

    public static int checkPalindrome(Node A) {

        if(A == null || A.next == null) return 1;

        Node mid = getMiddle(A);
        Node h1 = A;
        Node h2 = mid.next;
        mid.next = null;

        if(h2 == null) return 1;

        if(h1.next == null && h2.next == null) {
            if(h1.val == h2.val) return 1;
            else return 0;
        }

        h2 = reverse(h2);

        while(h1 != null && h2 != null) {
            if(h1.val != h2.val) return 0;
            h1 = h1.next;
            h2 = h2.next;
        }

        return 1;
    }

    private static Node getMiddle(Node root) {
        Node slow = root;
        Node fast = root;

        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static Node reverse(Node root) {
        Node prev = null;
        Node next = null;
        Node curr = root;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

class Node {
    public int val;
    public Node next;

    Node(int x) {
        val = x;
        next = null;
    }
}
