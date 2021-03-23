package tests.tree;

import org.junit.jupiter.api.Test;
import problems.tree.CheckBalanced;
import problems.tree.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class CheckBalancedTest {

    CheckBalanced checkBalanced;
    TreeNode<Integer> root;

    @Test
    void notBalanced() {
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(1);
        root.right = new TreeNode<>(1);
        root.left.left = new TreeNode<>(1);
        root.left.left.left = new TreeNode<>(1);
        checkBalanced = new CheckBalanced();
        assertFalse(checkBalanced.isBalanced(root));
    }

    @Test
    void balanced() {
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(1);
        root.right = new TreeNode<>(1);
        checkBalanced = new CheckBalanced();
        assertTrue(checkBalanced.isBalanced(root));
    }

}