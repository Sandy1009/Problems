/*
Given a singly linked list having n nodes containing english alphabets ('a'-'z').
Rearrange the linked list in such a way that all the vowels come before the consonants while maintaining the order of their arrival.

Input: n = 9
linked list: a -> b -> c -> d -> e -> f -> g -> h -> i
Output:  a -> e -> i -> b -> c -> d -> f -> g -> h
Explanation: After rearranging the input linked list according to the condition the resultant linked list will be as shown in output.
 */

import java.util.HashSet;
import java.util.Set;

class ListNodeChar {
    public char val;
    public ListNodeChar next;

    ListNodeChar(char x) {
        val = x;
        next = null;
    }
}

public class ArrangingVowelsAndConsonants {
    public static void main(String[] args) {
        /*ListNodeChar a = new ListNodeChar('a');
        a.next = new ListNodeChar('b');
        a.next.next = new ListNodeChar('c');
        a.next.next.next = new ListNodeChar('d');
        a.next.next.next.next = new ListNodeChar('e');
        a.next.next.next.next.next = new ListNodeChar('f');
        a.next.next.next.next.next.next = new ListNodeChar('g');
        a.next.next.next.next.next.next.next = new ListNodeChar('h');
        a.next.next.next.next.next.next.next.next = new ListNodeChar('i');*/

        //a -> b -> a -> b -> d -> e -> e -> d
        /*ListNodeChar a = new ListNodeChar('a');
        a.next = new ListNodeChar('b');
        a.next.next = new ListNodeChar('a');
        a.next.next.next = new ListNodeChar('b');
        a.next.next.next.next = new ListNodeChar('d');
        a.next.next.next.next.next = new ListNodeChar('e');
        a.next.next.next.next.next.next = new ListNodeChar('e');
        a.next.next.next.next.next.next.next = new ListNodeChar('d');*/

       /* ListNodeChar a = new ListNodeChar('k');
        a.next = new ListNodeChar('b');
        a.next.next = new ListNodeChar('g');
        a.next.next.next = new ListNodeChar('h');
        a.next.next.next.next = new ListNodeChar('d');
        a.next.next.next.next.next = new ListNodeChar('p');
        a.next.next.next.next.next.next = new ListNodeChar('m');
        a.next.next.next.next.next.next.next = new ListNodeChar('n');*/

       /* ListNodeChar a = new ListNodeChar('k');
        a.next = new ListNodeChar('b');
        a.next.next = new ListNodeChar('g');
        a.next.next.next = new ListNodeChar('h');
        a.next.next.next.next = new ListNodeChar('d');
        a.next.next.next.next.next = new ListNodeChar('p');
        a.next.next.next.next.next.next = new ListNodeChar('m');
        a.next.next.next.next.next.next.next = new ListNodeChar('a');*/

        ListNodeChar a = new ListNodeChar('a');
        a.next = new ListNodeChar('e');
        a.next.next = new ListNodeChar('i');
        a.next.next.next = new ListNodeChar('o');
        a.next.next.next.next = new ListNodeChar('o');
        a.next.next.next.next.next = new ListNodeChar('u');
        a.next.next.next.next.next.next = new ListNodeChar('a');
        a.next.next.next.next.next.next.next = new ListNodeChar('u');


        ListNodeChar result = arrangeCV(a);

        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }
    }

    static ListNodeChar arrangeCV(ListNodeChar head){

        /*ListNodeChar curr = head;
        ListNodeChar prev = null;
        ListNodeChar next = null;
        ListNodeChar prevPrev = null;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');   //a -> b -> a -> b -> d -> e -> e -> d

        while(curr != null) {
            while (curr != null && set.contains((char) curr.val)) {
                if(prev == null) prev = curr;
                curr = curr.next;
            }

            while (curr != null && !set.contains((char) curr.val)) {
                prevPrev = curr;
                curr = curr.next;
            }

            if(curr == null) break;

            next = curr.next;
            prevPrev.next = next;
            if(prev != null) {
                curr.next = prev.next;
                prev.next = curr;
                prev = prev.next;
            } else {
                curr.next = head;
                head = curr;
                prev = head;
            }
            curr = next;

        }

        return head;*/

        ListNodeChar vowelHead = null;
        ListNodeChar vowelTail = null;
        ListNodeChar consonantHead = null;
        ListNodeChar consonantTail = null;

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        ListNodeChar current = head;
        while (current != null) {
            ListNodeChar newNode = new ListNodeChar(current.val);
            if (vowels.contains(current.val)) {
                if (vowelHead == null) {
                    vowelHead = newNode;
                    vowelTail = newNode;
                } else {
                    vowelTail.next = newNode;
                    vowelTail = newNode;
                }
            } else {
                if (consonantHead == null) {
                    consonantHead = newNode;
                    consonantTail = newNode;
                } else {
                    consonantTail.next = newNode;
                    consonantTail = newNode;
                }
            }
            current = current.next;
        }

        if (vowelHead != null) {
            vowelTail.next = consonantHead;
            return vowelHead;
        } else {
            return consonantHead;
        }
    }

}
