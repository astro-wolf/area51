package tests;

import org.junit.jupiter.api.Test;
import problems.LRUCache;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    private LRUCache lruCache;

    @Test
    void empty() {
        lruCache = new LRUCache(5);
        assertEquals(-1, lruCache.get(4));
    }

    @Test
    void leetcode() {
        lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        assertEquals(1, lruCache.get(1));
        lruCache.put(3, 3);
        assertEquals(-1, lruCache.get(2));
        lruCache.put(4, 4);
        assertEquals(-1, lruCache.get(1));
        assertEquals(3, lruCache.get(3));
        assertEquals(4, lruCache.get(4));
    }

}