package tests;

import org.junit.jupiter.api.Test;
import problems.CustomStack;

import static org.junit.jupiter.api.Assertions.*;

class CustomStackTest {

    private CustomStack customStack;

    @Test
    void empty() {
        customStack = new CustomStack(1);
        assertEquals(-1, customStack.pop());
    }

    @Test
    void pushes() {
        customStack = new CustomStack(3);
        customStack.push(1);
        assertEquals(1, customStack.peek());
        customStack.push(2);
        assertEquals(2, customStack.peek());
        customStack.push(3);
        assertEquals(3, customStack.peek());
        customStack.push(4);
        assertEquals(3, customStack.peek());
    }

    @Test
    void pops() {
        customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        assertEquals(3, customStack.pop());
        assertEquals(2, customStack.pop());
        assertEquals(1, customStack.pop());
        assertEquals(-1, customStack.pop());
        assertEquals(-1, customStack.pop());
        assertEquals(-1, customStack.pop());
    }

    @Test
    void increment() {
        customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        customStack.increment(15, 100);
        assertEquals(103, customStack.peek());
    }

}