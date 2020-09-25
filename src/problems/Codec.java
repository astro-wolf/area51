package problems;

import java.util.Stack;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 12/09/20 00:05
 *
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 *
 * Serialization is the process of converting a data structure or object into a sequence
 * of bits so that it can be stored in a file or memory buffer, or transmitted across a
 * network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree. There is no
 * restriction on how your serialization/deserialization algorithm should work. You just
 * need to ensure that a binary search tree can be serialized to a string and this
 * string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 *
 * Note: Do not use class member/global/static variables to store states.
 * Your serialize and deserialize algorithms should be stateless.
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return null;
        return getPreOrderString(root) + ":" + getInOrderString(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;
        String[] traversals = data.split(":");
        String[] preOrder = traversals[0].split(",");
        String[] inOrder = traversals[1].split(",");
        return makeTree(preOrder, 0, preOrder.length - 1,
                inOrder, 0, inOrder.length - 1);
    }

    private String getInOrderString(TreeNode root) {
        StringBuilder res = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        boolean done = true;
        TreeNode curr = root;
        String prefix = "";
        while (done) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty()) {
                    done = false;
                } else {
                    curr = stack.pop();
                    res.append(prefix);
                    prefix = ",";
                    res.append(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res.toString();
    }

    private String getPreOrderString(TreeNode root) {
        StringBuilder res = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        String prefix = "";
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.append(prefix);
            prefix = ",";
            res.append(curr.val);
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
        return res.toString();
    }

    private TreeNode makeTree(String[] preOrder,
                              int preStart,
                              int preEnd,
                              String[] inOrder,
                              int inStart,
                              int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        int data = Integer.parseInt(preOrder[preStart]);
        TreeNode node = new TreeNode(data);
        int offset = inStart;
        for (; offset < inEnd; offset++) {
            if (Integer.parseInt(inOrder[offset]) == data)
                break;
        }
        node.left = makeTree(preOrder, preStart + 1, preStart + offset - inStart,
                inOrder, inStart, offset - 1);
        node.right = makeTree(preOrder, preStart + offset - inStart + 1, preEnd,
                inOrder, offset + 1, inEnd);
        return node;
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
