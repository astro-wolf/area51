package problems;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 29/08/20 22:48
 *
 * https://leetcode.com/problems/min-stack/submissions/
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 * Constraints:
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 */
public class MinStack {

    private MuaLL head;

    public MinStack() {
        head = null;
    }

    public void push(int x) {
        if (head == null)
            head = new MuaLL(x, x, null);
        else {
            head = new MuaLL(x,
                    Math.min(x, head.min),
                    head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class MuaLL {
        int val, min;
        MuaLL next;
        MuaLL(int val, int min, MuaLL next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

}
