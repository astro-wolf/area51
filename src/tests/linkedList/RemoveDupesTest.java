package tests.linkedList;

import org.junit.jupiter.api.Test;
import problems.linkedList.MyLinkedList;
import problems.linkedList.Node;
import problems.linkedList.RemoveDupes;

class RemoveDupesTest {

    private RemoveDupes removeDupes;

    @Test
    void general() {
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(12);
        ll.addAtTail(9);
        ll.addAtTail(12);
        ll.addAtTail(1);
        ll.addAtTail(3);
        ll.addAtTail(9);
        ll.addAtTail(4);
        ll.addAtTail(3);
        ll.addAtTail(1);
        removeDupes = new RemoveDupes();
        Node res = removeDupes.removeDups(ll.head);
        System.out.println(res);
    }

}