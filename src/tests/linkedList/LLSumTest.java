package tests.linkedList;

import org.junit.jupiter.api.Test;
import problems.linkedList.LLSum;
import problems.linkedList.Node;

import static org.junit.jupiter.api.Assertions.*;

class LLSumTest {

    private LLSum llSum;

    @Test
    void sameLengths() {
        Node h1 = new Node(6);
        h1.next = new Node(1);
        h1.next.next= new Node(7);

        Node h2 = new Node(2);
        h2.next = new Node(9);
        h2.next.next= new Node(5);

        llSum = new LLSum();
        Node res = llSum.sum(h1, h2);
        System.out.println(res);
    }

    @Test
    void diffLengths() {
        Node h1 = new Node(2);
        h1.next = new Node(3);

        Node h2 = new Node(4);
        h2.next = new Node(3);
        h2.next.next = new Node(2);
        h2.next.next.next = new Node(1);

        llSum = new LLSum();
        Node res = llSum.sum(h1, h2);
        System.out.println(res);
    }

    @Test
    void extraCarry() {
        Node h1 = new Node(9);
        h1.next = new Node(9);
        Node h2 = new Node(9);
        h2.next = new Node(9);

        llSum = new LLSum();
        Node res = llSum.sum(h1, h2);
        System.out.println(res);
    }

}