package problems.linkedList;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 09/03/2021 08:23
 */
public class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
