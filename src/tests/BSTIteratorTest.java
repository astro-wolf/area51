package tests;

import org.junit.jupiter.api.Test;
import problems.BSTIterator;

import static org.junit.jupiter.api.Assertions.*;

class BSTIteratorTest {

    private BSTIterator bstIterator;

    @Test
    void empty() {
        bstIterator = new BSTIterator(null);
        assertFalse(bstIterator.hasNext());
    }

    @Test
    void onlyLeft() {
        BSTIterator.TreeNode root = new BSTIterator.TreeNode(6);
        root.left = new BSTIterator.TreeNode(5,
                new BSTIterator.TreeNode(4,
                        new BSTIterator.TreeNode(3),
                        null),
                null);
        bstIterator = new BSTIterator(root);
        assertEquals(3, bstIterator.next());
        assertEquals(4, bstIterator.next());
        assertEquals(5, bstIterator.next());
        assertTrue(bstIterator.hasNext());
        assertEquals(6, bstIterator.next());
        assertFalse(bstIterator.hasNext());
    }

}