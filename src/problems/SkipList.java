package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 25/08/20 18:17
 *
 * https://leetcode.com/problems/design-skiplist/
 *
 * Design a Skiplist without using any built-in libraries.
 *
 * A Skiplist is a data structure that takes O(log(n)) time to add, erase and search.
 * Comparing with treap and red-black tree which has the same function and performance,
 * the code length of Skiplist can be comparatively short and the idea behind Skiplists
 * are just simple linked lists.
 *
 * There are many layers in the Skiplist. Each layer is a sorted linked list.
 * With the help of the top layers, add , erase and search can be faster than O(n).
 * It can be proven that the average time complexity for each operation is O(log(n))
 * and space complexity is O(n).
 *
 * To be specific, your design should include these functions:
 *
 * bool search(int target) : Return whether the target exists in the Skiplist or not.
 * void add(int num): Insert a value into the SkipList.
 * bool erase(int num): Remove a value in the Skiplist. If num does not exist in the Skiplist,
 * do nothing and return false. If there exists multiple num values, removing any one of them is fine.
 * See more about Skiplist : https://en.wikipedia.org/wiki/Skip_list
 *
 * Note that duplicates may exist in the Skiplist, your code needs to handle this situation.
 *
 * Example:
 *
 * Skiplist skiplist = new Skiplist();
 *
 * skiplist.add(1);
 * skiplist.add(2);
 * skiplist.add(3);
 * skiplist.search(0);   // return false.
 * skiplist.add(4);
 * skiplist.search(1);   // return true.
 * skiplist.erase(0);    // return false, 0 is not in skiplist.
 * skiplist.erase(1);    // return true.
 * skiplist.search(1);   // return false, 1 has already been erased.
 */
public class SkipList {

    private List<Node> sentinals;
    private double PROB = 0.5;
    private Random random = new Random();

    public SkipList() {
        sentinals = new ArrayList<>();
        sentinals.add(new Node(Integer.MIN_VALUE));
    }

    public boolean search(int target) {
        return getSmallerOrEqual(target).val == target;
    }

    public void add(int num) {
        Node toInsert = new Node(num);
        Node prev = getSmallerOrEqual(num);
        add(prev, toInsert);
        populateLevelUp(toInsert);
    }

    public boolean erase(int num) {
        Node target = getSmallerOrEqual(num);
        if (target.val != num)
            return false;
        while (target != null) {
            Node right = target.right;
            Node left = target.left;
            left.right = right;
            if (right != null)
                right.left = left;
            target = target.up;
        }
        return true;
    }

    private void add(Node prev, Node toInsert) {
        Node right = prev.right;
        prev.right = toInsert;
        toInsert.left = prev;
        if (right != null) {
            toInsert.right = right;
            right.left = toInsert;
        }
    }

    private void populateLevelUp(Node curr) {
        while (flipCoin()) {
            Node cp = curr.left;
            while (cp.left != null && cp.up == null)
                cp = cp.left;
            if (cp.up == null) {// we reached sentinal, and there's no upper level
                Node sentinal = new Node(Integer.MIN_VALUE);
                cp.up = sentinal;
                sentinal.down = cp;
                sentinals.add(sentinal);
            }
            cp = cp.up;
            Node currUp = new Node(curr.val);
            curr.up = currUp;
            currUp.down = curr;
            Node right = cp.right;
            curr = currUp;
            cp.right = curr;
            curr.left = cp;
            if (right != null) {
                curr.right = right;
                right.left = curr;
            }
        }
    }

    private Node getSmallerOrEqual(int target) {
        Node curr = sentinals.get(sentinals.size() - 1); // get top most element
        while (curr != null)
            if (curr.right == null || curr.right.val > target) {
                if (curr.down == null)
                    break;
                curr = curr.down;
            } else {
                curr = curr.right;
            }
        return curr;
    }

    private boolean flipCoin() {
        return random.nextDouble() > PROB;
    }

    private class Node {
        int val;
        Node left, right, up, down;

        public Node(int val) {
            this.val = val;
        }
    }

}
