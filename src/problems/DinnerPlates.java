package problems;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 30/08/20 23:19
 *
 * https://leetcode.com/problems/dinner-plate-stacks/
 *
 * You have an infinite number of stacks arranged in a row and numbered (left to right) from 0,
 * each of the stacks has the same maximum capacity.
 *
 * Implement the DinnerPlates class:
 *
 * DinnerPlates(int capacity) Initializes the object with the maximum capacity of the stacks.
 * void push(int val) pushes the given positive integer val into the leftmost stack with size less than capacity.
 * int pop() returns the value at the top of the rightmost non-empty stack and removes it from that stack,
 * and returns -1 if all stacks are empty.
 * int popAtStack(int index) returns the value at the top of the stack with the given index and
 * removes it from that stack, and returns -1 if the stack with that given index is empty.
 *
 * Example:
 * Input:
 * ["DinnerPlates","push","push","push","push","push","popAtStack","push","push",
 * "popAtStack","popAtStack","pop","pop","pop","pop","pop"]
 * [[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
 * Output:
 * [null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
 *
 * Explanation:
 * DinnerPlates D = DinnerPlates(2);  // Initialize with capacity = 2
 * D.push(1);
 * D.push(2);
 * D.push(3);
 * D.push(4);
 * D.push(5);         // The stacks are now:  2  4
 *                                            1  3  5
 *                                            ﹈ ﹈ ﹈
 * D.popAtStack(0);   // Returns 2.  The stacks are now:     4
 *                                                        1  3  5
 *                                                        ﹈ ﹈ ﹈
 * D.push(20);        // The stacks are now: 20  4
 *                                            1  3  5
 *                                            ﹈ ﹈ ﹈
 * D.push(21);        // The stacks are now: 20  4 21
 *                                            1  3  5
 *                                            ﹈ ﹈ ﹈
 * D.popAtStack(0);   // Returns 20.  The stacks are now:     4 21
 *                                                         1  3  5
 *                                                         ﹈ ﹈ ﹈
 * D.popAtStack(2);   // Returns 21.  The stacks are now:     4
 *                                                         1  3  5
 *                                                         ﹈ ﹈ ﹈
 * D.pop()            // Returns 5.  The stacks are now:      4
 *                                                         1  3
 *                                                         ﹈ ﹈
 * D.pop()            // Returns 4.  The stacks are now:   1  3
 *                                                         ﹈ ﹈
 * D.pop()            // Returns 3.  The stacks are now:   1
 *                                                         ﹈
 * D.pop()            // Returns 1.  There are no stacks.
 * D.pop()            // Returns -1.  There are still no stacks.
 *
 * Constraints:
 *
 * 1 <= capacity <= 20000
 * 1 <= val <= 20000
 * 0 <= index <= 100000
 * At most 200000 calls will be made to push, pop, and popAtStack.
 */
public class DinnerPlates {

    private ArrayList<Stack<Integer>> dinnerPlates;
    private int left = 0, right = -1, maxAllowed = 0;

    public DinnerPlates(int capacity) {
        dinnerPlates = new ArrayList<Stack<Integer>>();
        maxAllowed = capacity;
        dinnerPlates.add(new Stack<Integer>());
    }

    public void push(int val) {
        Stack<Integer> curr = getStackAtIndex(left);
        curr.push(val);
        if (left > right)
            right = left;
        if (curr.size() == maxAllowed)
            setLeftPtr();
    }

    public int pop() {
        if (right == -1)
            return right;
        Stack<Integer> curr = getStackAtIndex(right);
        if (curr.isEmpty())
            return -1;
        int temp = curr.pop();
        if (right < left)
            left = right;
        if (curr.isEmpty())
            setRightPtr();
        return temp;
    }

    public int popAtStack(int index) {
        Stack<Integer> curr = getStackAtIndex(index);
        if (curr == null || curr.isEmpty())
            return -1;
        int temp = curr.pop();
        if (index < left)
            left = index;
        if (index == right && curr.isEmpty())
            setRightPtr();
        return temp;
    }

    private void setLeftPtr() {
        while (left < dinnerPlates.size()
                && getStackAtIndex(left).size() == maxAllowed)
            left++;
        if (left >= dinnerPlates.size())
            dinnerPlates.add(new Stack<>());
    }

    private void setRightPtr() {
        while (right > 0
                && getStackAtIndex(right).isEmpty())
            right--;
    }

    private Stack<Integer> getStackAtIndex(int index) {
        if (index >= dinnerPlates.size())
            return null;
        return dinnerPlates.get(index);
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

}
