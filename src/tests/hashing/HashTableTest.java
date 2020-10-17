package tests.hashing;

import org.junit.jupiter.api.Test;
import problems.hashing.HashTable;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    private HashTable hashTable;

    @Test
    void full() {
        hashTable = new HashTable(3);
        hashTable.add(1);
        hashTable.add(2);
        hashTable.add(3);
        assertFalse(hashTable.add(234));
    }

    @Test
    void dupe() {
        hashTable = new HashTable(3);
        hashTable.add(1);
        hashTable.add(2);
        hashTable.add(2);
        assertTrue(hashTable.add(3));
    }

    @Test
    void remove() {
        hashTable = new HashTable(3);
        hashTable.add(1);
        hashTable.add(2);
        hashTable.add(3);
        assertTrue(hashTable.remove(3));
        assertFalse(hashTable.remove(2342));
        assertTrue(hashTable.add(3));
    }

    @Test
    void find() {
        hashTable = new HashTable(3);
        hashTable.add(1234);
        hashTable.add(2345);
        hashTable.add(3456);
        assertTrue(hashTable.contains(1234));
        assertFalse(hashTable.contains(12345));
    }

}