package tests.tree;

import org.junit.jupiter.api.Test;
import problems.tree.Trie;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    private Trie trie;

    @Test
    void initAndWholeMatch() {
        trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.exist("apple"));
    }

    @Test
    void multipleInsertsAndMatches() {
        trie = new Trie();
        trie.insert("apple");
        trie.insert("application");
        assertTrue(trie.exist("apple"));
        assertTrue(trie.exist("application"));
    }

    @Test
    void dontMatchAtAll() {
        trie = new Trie();
        trie.insert("apple");
        assertFalse(trie.exist("somethingelse"));
    }

    @Test
    void failMidWayBecauseNoEnd() {
        trie = new Trie();
        trie.insert("apple");
        trie.insert("application");
        assertFalse(trie.exist("app"));
    }

    @Test
    void failMidWayBecauseNoMatch() {
        trie = new Trie();
        trie.insert("carpenter");
        trie.insert("cardigan");
        assertFalse(trie.exist("cat"));
    }

}