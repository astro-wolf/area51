package tests;

import org.junit.jupiter.api.Test;
import problems.MyCircularQueue;

import static org.junit.jupiter.api.Assertions.*;

class MyCircularQueueTest {

    private MyCircularQueue myCircularQueue;

    @Test
    void empty() {
        myCircularQueue = new MyCircularQueue(4);
        assertTrue(myCircularQueue.isEmpty());
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.deQueue();
        myCircularQueue.deQueue();
        assertTrue(myCircularQueue.isEmpty());
        assertFalse(myCircularQueue.isFull());
    }

    @Test
    void full() {
        myCircularQueue = new MyCircularQueue(2);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(1);
        assertTrue(myCircularQueue.isFull());
        assertFalse(myCircularQueue.isEmpty());
    }

    @Test
    void enqueue() {
        myCircularQueue = new MyCircularQueue(3);
        assertTrue(myCircularQueue.enQueue(1));
        assertTrue(myCircularQueue.enQueue(1));
        assertTrue(myCircularQueue.enQueue(1));
        assertFalse(myCircularQueue.enQueue(1));
    }

    @Test
    void dequeue() {
        myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        assertTrue(myCircularQueue.deQueue());
        assertTrue(myCircularQueue.deQueue());
        assertTrue(myCircularQueue.deQueue());
        assertFalse(myCircularQueue.deQueue());
        assertFalse(myCircularQueue.deQueue());
    }

    @Test
    void frontAndRear() {
        myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        assertEquals(1, myCircularQueue.Front());
        assertEquals(3, myCircularQueue.Rear());
    }

}