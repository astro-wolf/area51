package problems;

import java.util.HashMap;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 15/09/20 09:32
 *
 * https://leetcode.com/problems/lru-cache/
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support
 * the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache
 * reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1);
 * lRUCache.put(2, 2);
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // evicts key 2
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // evicts key 1
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 *
 * Constraints:
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * At most 3 * 104 calls will be made to get and put.
 */
public class LRUCache {

    private int capacity = 0;
    private int count = 0;
    private DllNode head, tail;
    private HashMap<Integer, DllNode> kvs = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (count == 0 || !kvs.containsKey(key))
            return -1;
        DllNode node = kvs.get(key);
        if (node != head) {
            node.prev.next = node.next;
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            node.next = head;
            head.prev = node;
            head = node;
        }
        return head.val;
    }

    public void put(int key, int value) {
        DllNode node = new DllNode(key, value);
        if (count == capacity) {
            kvs.remove(head.key);
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            count--;
        }
        if (head == null) {
            head = node;
            tail = node;
            count = 1;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
            count++;
        }
        kvs.put(key, tail);
    }

    private class DllNode {
        public int val;
        public int key;
        public DllNode prev;
        public DllNode next;
        DllNode() {}
        DllNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
