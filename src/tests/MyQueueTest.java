package tests;

import org.junit.jupiter.api.Test;
import problems.MyQueue;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    private MyQueue myQueue;

    @Test
    void empty() {
        myQueue = new MyQueue();
        assertTrue(myQueue.empty());
    }

    @Test
    void pushes() {
        myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        assertEquals(1, myQueue.peek());
    }

    @Test
    void pops() {
        myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        assertEquals(1, myQueue.pop());
        assertEquals(2, myQueue.pop());
        assertEquals(3, myQueue.peek());
    }

}