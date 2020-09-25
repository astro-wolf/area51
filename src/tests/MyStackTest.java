package tests;

import org.junit.jupiter.api.Test;
import problems.MyStack;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    private MyStack myStack;

    @Test
    void empty() {
        myStack = new MyStack();
        assertTrue(myStack.empty());
    }

    @Test
    void consecutiveInserts() {
        myStack = new MyStack();
        myStack.push(1);
        assertEquals(1, myStack.top());
        myStack.push(2);
        assertEquals(2, myStack.top());
        myStack.push(3);
        assertEquals(3, myStack.top());
    }

    @Test
    void consecutiveRemoves() {
        myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        assertEquals(5, myStack.pop());
        assertEquals(4, myStack.pop());
        assertEquals(3, myStack.pop());
        assertEquals(2, myStack.pop());
        assertEquals(1, myStack.pop());
        assertTrue(myStack.empty());
    }

}