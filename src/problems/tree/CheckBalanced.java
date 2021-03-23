package problems.tree;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 23/03/2021 22:08
 */
public class CheckBalanced {

    public boolean isBalanced(TreeNode root) {
        int res = getHeight(root);
        return res >= 0;
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1)
            return -1;
        return 1 + Math.max(lh, rh);
    }

}
