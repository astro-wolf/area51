package tests;

import org.junit.jupiter.api.Test;
import problems.DinnerPlates;

import static org.junit.jupiter.api.Assertions.*;

class DinnerPlatesTest {

    private DinnerPlates dinnerPlates;

    @Test
    void empty() {
        dinnerPlates = new DinnerPlates(3);
        assertEquals(-1, dinnerPlates.pop());
    }

    @Test
    void inserts() {
        dinnerPlates = new DinnerPlates(2);
        dinnerPlates.push(1);
        dinnerPlates.push(2);
        dinnerPlates.push(3);
        dinnerPlates.push(4);
        dinnerPlates.push(5);
        dinnerPlates.push(6);
        dinnerPlates.push(7);
        dinnerPlates.push(8);
        dinnerPlates.push(9);
        dinnerPlates.push(10);
        dinnerPlates.push(11);
        assertEquals(11, dinnerPlates.pop());
    }

    @Test
    void emptyAfterPops() {
        dinnerPlates = new DinnerPlates(2);
        dinnerPlates.push(1);
        dinnerPlates.push(2);
        dinnerPlates.push(3);
        dinnerPlates.push(4);
        dinnerPlates.push(5);
        dinnerPlates.push(6);
        dinnerPlates.push(7);
        dinnerPlates.push(8);
        dinnerPlates.push(9);
        dinnerPlates.push(10);
        dinnerPlates.push(11);
        assertEquals(11, dinnerPlates.pop());
        assertEquals(-1, dinnerPlates.popAtStack(5));
    }

    @Test
    void popFromMids() {
        dinnerPlates = new DinnerPlates(2);
        dinnerPlates.push(1);
        dinnerPlates.push(2);//0
        dinnerPlates.push(3);
        dinnerPlates.push(4);//1
        dinnerPlates.push(5);
        dinnerPlates.push(6);//2
        dinnerPlates.push(7);
        dinnerPlates.push(8);//3
        dinnerPlates.push(9);
        dinnerPlates.push(10);//4
        assertEquals(6, dinnerPlates.popAtStack(2));
        assertEquals(2, dinnerPlates.getLeft());
    }

    @Test
    void popFromMidsAndThenPop() {
        dinnerPlates = new DinnerPlates(2);
        dinnerPlates.push(1);
        dinnerPlates.push(2);//0
        dinnerPlates.push(3);
        dinnerPlates.push(4);//1
        dinnerPlates.push(5);
        dinnerPlates.push(6);//2
        dinnerPlates.push(7);
        dinnerPlates.push(8);//3
        dinnerPlates.push(9);
        dinnerPlates.push(10);//4
        assertEquals(8, dinnerPlates.popAtStack(3));
        assertEquals(7, dinnerPlates.popAtStack(3));
        assertEquals(-1, dinnerPlates.popAtStack(3));
        assertEquals(10, dinnerPlates.pop());
        assertEquals(9, dinnerPlates.pop());
        assertEquals(2, dinnerPlates.getRight());
        assertEquals(3, dinnerPlates.getLeft());
    }

    @Test
    void leetcode() {
        dinnerPlates = new DinnerPlates(2);
        dinnerPlates.push(1);
        dinnerPlates.push(2);
        dinnerPlates.push(3);
        dinnerPlates.push(4);
        dinnerPlates.push(5);
        dinnerPlates.popAtStack(0);
        dinnerPlates.push(20);
        dinnerPlates.push(21);
        dinnerPlates.popAtStack(0);
        dinnerPlates.popAtStack(2);
        dinnerPlates.pop();
        dinnerPlates.pop();
        dinnerPlates.pop();
        dinnerPlates.pop();
        dinnerPlates.pop();
    }

}