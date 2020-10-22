package tests.tree;

import org.junit.jupiter.api.Test;
import problems.tree.TernarySearchTree;

import static org.junit.jupiter.api.Assertions.*;

class TernarySearchTreeTest {

    private TernarySearchTree tst;

    @Test
    void empty() {
        tst = new TernarySearchTree();
        assertFalse(tst.search("some thing that doesn't exist"));
    }

    @Test
    void foundInOneInsert() {
        tst = new TernarySearchTree();
        tst.insert("apple");
        assertTrue(tst.search("apple"));
    }

    @Test
    void foundInMultipleInserts() {
        tst = new TernarySearchTree();
        tst.insert("apple");
        tst.insert("app");
        assertTrue(tst.search("app"));
        assertTrue(tst.search("apple"));
    }

    @Test
    void insertsWithMultipleReUses() {
        tst = new TernarySearchTree();
        tst.insert("call");
        tst.insert("me");
        tst.insert("mind");
        tst.insert("mid");
        assertTrue(tst.search("call"));
        assertTrue(tst.search("me"));
        assertTrue(tst.search("mind"));
        assertTrue(tst.search("mid"));
    }

}