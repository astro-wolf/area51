package problems.tree;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 23/10/20 00:10
 */
public class TernarySearchTree {

    private TSTNode head;

    public void insert(String s) {
        head = insert(head, s.toCharArray(), 0);
    }

    public boolean search(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        TSTNode curr = head;
        while (curr != null) {
            if (c[i] < curr.val)
                curr  = curr.left;
            if (c[i] > curr.val)
                curr = curr.right;
            else {
                if (i == c.length - 1 && curr.end)
                    return true;
                else {
                    curr = curr.eq;
                    i++;
                }
            }
        }
        return false;
    }

    private TSTNode insert(TSTNode root, char[] c, int position) {
        if (root == null)
            root = new TSTNode(c[position]);
        if (c[position] < root.val)
            root.left = insert(root.left, c, position);
        else if (c[position] > root.val)
            root.right = insert(root.right, c, position);
        else {
            if (position == c.length - 1) {
                root.end = true;
                return root;
            } else {
                root.eq = insert(root.eq, c, position + 1);
            }
        }
        return root;
    }

    class TSTNode {
        char val;
        TSTNode left, eq, right;
        boolean end = false;

        TSTNode(char val) {
            this.val = val;
        }
    }
}
