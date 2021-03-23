package problems.linkedList;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 11/03/2021 22:30
 */
public class LLSum {

    int carry = 0;

    public Node sum(Node h1, Node h2) {
        int h1l = getLength(h1);
        int h2l = getLength(h2);
        int diff = Math.abs(h1l - h2l);
        Node res = new Node(-1);
        if (h1l < h2l) {
            Node temp = h2;
            h2 = h1;
            h1 = temp;
            res.next = h2;
        } else {
            res = h2;
        }
        res.next = sum(h1, res, diff);
        if (carry == 1) {
            res.val = 1;
            return res;
        }
        return res.next;
    }

    private Node sum(Node h1, Node h2, int diff) {
        if (h1 == null && h2 == null)
            return null;
        int x, y;
        x = h1.val;
        if (diff > 0) {
            diff--;
            y = 0;
        } else {
            y = h2.val;
        }
        Node next = sum(h1.next, diff > 0 ? h2 : h2.next, diff);
        int sum = x + y + carry;
        if (sum > 10) {
            sum %= 10;
            carry = 1;
        } else {
            carry = 0;
        }
        Node curr = new Node(sum);
        curr.next = next;
        return curr;
    }

    private int getLength(Node h1) {
        int len = 0;
        Node curr = h1;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }

}
