package problems;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 29/08/20 23:11
 *
 * https://leetcode.com/problems/max-stack/
 *
 * No description, since haven't got premium yet. Shall go with all the methods from MinStack problem ;-)
 */
public class MaxStack {

    private MaxNode head;

    public MaxStack() {
        head = null;
    }

    public void push(int val) {
        if (head == null)
            head = new MaxNode(val, val, null);
        else
            head = new MaxNode(val,
                    Math.max(val, head.max),
                    head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int max() {
        return head.max;
    }

    private class MaxNode  {
        int val, max;
        MaxNode next;
        MaxNode(int val, int max, MaxNode next) {
            this.val = val;
            this.max = max;
            this.next = next;
        }
    }

}
