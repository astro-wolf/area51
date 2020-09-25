package tests;

import org.junit.jupiter.api.Test;
import problems.MinStack;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    private MinStack minStack;

    @Test
    void pushes() {
        minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        assertEquals(4, minStack.top());
    }

    @Test
    void min() {
        minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        assertEquals(1, minStack.getMin());
    }

    @Test
    void popAndMin() {
        minStack = new MinStack();
        minStack.push(4);
        minStack.push(2);
        minStack.push(3);
        minStack.push(1);
        assertEquals(1, minStack.getMin());
        minStack.pop();
        assertEquals(2, minStack.getMin());
    }

}