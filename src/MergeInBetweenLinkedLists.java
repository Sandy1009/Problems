public class MergeInBetweenLinkedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        // Create ListNode instances for list1 and list2
        ListNode list1 = createLinkedList(new int[]{10, 1, 13, 6, 9, 5});
        ListNode list2 = createLinkedList(new int[]{1000000, 1000001, 1000002});

        int a = 3;
        int b = 4;
        // Call mergeInBetween method with the inputs
        ListNode result = mergeInBetween(list1, a, b, list2);

        // Print the merged list
        printLinkedList(result);
    }

    private static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

            int count = 1;
            ListNode temp = null;
            ListNode head1 = list1;
            ListNode tail2 = null;
            ListNode head2 = list2;

            while(count < a) {
                list1 = list1.next;
                count++;
            }

            temp = list1.next;
            list1.next = list2;

            while(list2.next != null) {
                list2 = list2.next;
            }

            while(count <= b) {
                temp = temp.next;
                count++;
            }

            list2.next = temp;

            return head1;


        }
    }

