package problems.tree;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 23/03/2021 22:07
 */
public class TreeNode<T> {

    public TreeNode(T val) {
        this.val = val;
    }

    public T val;
    public TreeNode left;
    public TreeNode right;

}
