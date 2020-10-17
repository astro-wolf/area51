package problems.hashing;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 17/10/20 23:27
 *
 * This class implements separate chaining technique for Hashing.
 *
 * Only integers are allowed here :P
 */
public class HashTable {

    private int count = 0;
    private int capacity = 0;
    private ListNode[] arr;

    public HashTable(int size) {
        arr = new ListNode[size];
        this.capacity = size;
    }

    public boolean contains(int val) {
        int index = hash(val);
        ListNode head = arr[index];
        while (head != null) {
            if (head.val == val)
                return true;
            else
                head = head.next;
        }
        return false;
    }

    /**
     * Add a new value to HashTable. If a value already exists, this will do nothing.
     * @param val
     * @return
     */
    public boolean add(int val) {
        if (count == arr.length)
            return false;
        int index = hash(val);
        ListNode newNode = new ListNode(val);
        if (arr[index] == null) {
            arr[index] = newNode;
        } else {
            ListNode head = arr[index];
            ListNode prev = head;
            while (head != null) {
                if (head.val == val) {
                    return true;
                } else {
                    prev = head;
                    head = head.next;
                }
            }
            prev.next = newNode;
        }
        count++;
        return true;
    }

    public boolean remove(int val) {
        int index = hash(val);
        ListNode head = arr[index];
        if (head != null && head.val == val) {
            arr[index] = head.next;
            count--;
            return true;
        } else {
            while (head != null && head.next != null) {
                if (head.next.val == val) {
                    head.next = head.next.next;
                    count--;
                    return true;
                } else {
                    head = head.next;
                }
            }
            return false;
        }
    }

    private int hash(int val) {
        return val % capacity;
    }

    private class ListNode {
        public int val;
        public ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
