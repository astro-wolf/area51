package tests;

import org.junit.jupiter.api.Test;
import problems.linkedList.MyLinkedList;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    private MyLinkedList myLinkedList;

    @Test
    void failingTest() {
        myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(4);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(5);
        myLinkedList.deleteAtIndex(3);
        myLinkedList.addAtHead(7);
        assertEquals(4, myLinkedList.get(3));
    }

    @Test
    void myOwnTest() {
        myLinkedList = new MyLinkedList();
        assertTrue(myLinkedList.isEmpty());

        myLinkedList.addAtIndex(0, 1);
        assertFalse(myLinkedList.isEmpty());
        assertEquals(1, myLinkedList.size());
        assertEquals(1, myLinkedList.get(0));

        myLinkedList.addAtTail(2);
        assertEquals(2, myLinkedList.get(1));

        myLinkedList.addAtIndex(2, 3);
        assertEquals(3, myLinkedList.get(2));

        myLinkedList.addAtTail(5);
        myLinkedList.addAtTail(6);
        myLinkedList.addAtTail(7);
        myLinkedList.addAtIndex(3, 4);
        assertEquals(4, myLinkedList.get(3));

        myLinkedList.addAtIndex(0, -1);
        assertEquals(-1, myLinkedList.get(0));

        myLinkedList.deleteAtIndex(0);
        assertEquals(1, myLinkedList.get(0));

        myLinkedList.deleteAtIndex(myLinkedList.size() - 1);
        assertEquals(6, myLinkedList.get(myLinkedList.size() - 1));

        //invalid index for deletion
        myLinkedList.deleteAtIndex(15);
        assertEquals(6, myLinkedList.size());

        myLinkedList.deleteAtIndex(2);
        assertEquals(4, myLinkedList.get(2));
    }
}