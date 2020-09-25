package problems;

import java.util.Iterator;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 07/08/20 07:15
 * <p>
 * https://leetcode.com/problems/design-linked-list/
 * <p>
 * Design your implementation of the linked list. You can choose to use the singly linked list or
 * the doubly linked list. A node in a singly linked list should have two attributes: val and next.
 * val is the value of the current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate
 * the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement these functions in your linked list class:
 * <p>
 * get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * <p>
 * addAtHead(val) : Add a node of value val before the first element of the linked list.
 * After the insertion, the new node will be the first node of the linked list.
 * <p>
 * addAtTail(val) : Append a node of value val to the last element of the linked list.
 * <p>
 * addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list.
 * If index equals to the length of linked list, the node will be appended to the end of linked list.
 * If index is greater than the length, the node will not be inserted.
 * <p>
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 * <p>
 * Example:
 * <p>
 * Input:
 * ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
 * [[],[1],[3],[1,2],[1],[1],[1]]
 * Output:
 * [null,null,null,null,2,null,3]
 * <p>
 * Explanation:
 * MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 * <p>
 * Constraints:
 * <p>
 * 0 <= index,val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail,  addAtIndex and deleteAtIndex.
 */
public class MyLinkedList {

    private int size = 0;
    private Node head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size || isEmpty())
            return -1;
        int i = 0; Node temp = head;
        while (i < index) {
            i++;
            temp = temp.next;
        }
        return temp.val;
    }

    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (isEmpty())
            addAtHead(val);
        else {
            Node temp = head, newNode = new Node(val);
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size)
            return;
        if (index == 0)
            addAtHead(val);
        else if (index == size)
            addAtTail(val);
        else {
            int i = 0;
            Node temp = head, newNode = new Node(val);
            while (i < index - 1) {
                i++;
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    private void deleteHead() {
        head = head.next;
        size--;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (isEmpty() || index >= size)
            return;
        if (index == 0)
            deleteHead();
        else {
            int i = 0;
            Node temp = head;
            while (i < index - 1) {
                i++;
                temp =temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }

    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}