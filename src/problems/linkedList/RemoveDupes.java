package problems.linkedList;

import java.util.HashSet;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 08/03/2021 22:46
 */
public class RemoveDupes {

    public Node removeDups(Node head) {
        HashSet<Integer> values = new HashSet<>();
        Node curr = head, previous = null;
        while (curr != null) {
            if (values.contains(curr.val)) {
                previous.next = curr.next;
            } else {
                values.add(curr.val);
                previous = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    public Node removeDupes(Node head) {
        Node curr = head;
        while (curr != null) {
            Node next = curr;
            while (next.next != null) {
                if (curr.val == next.next.val) {
                    next.next = next.next.next;
                } else {
                    next = next.next;
                }
            }
            curr = curr.next;
        }
        return head;
    }

}
