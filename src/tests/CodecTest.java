package tests;

import org.junit.jupiter.api.Test;
import problems.Codec;

import static org.junit.jupiter.api.Assertions.*;

class CodecTest {

    private Codec codec;

    @Test
    void empty() {
        codec = new Codec();
        assertNull(codec.deserialize(null));
        assertNull(codec.deserialize(""));
        assertNull(codec.serialize(null));
    }

    @Test
    void testing() {
        codec = new Codec();
        Codec.TreeNode one = new Codec.TreeNode(1);
        Codec.TreeNode two = new Codec.TreeNode(2);
        Codec.TreeNode three = new Codec.TreeNode(3);
        Codec.TreeNode four = new Codec.TreeNode(4);
        Codec.TreeNode five = new Codec.TreeNode(5);
        Codec.TreeNode six = new Codec.TreeNode(6);
        Codec.TreeNode seven = new Codec.TreeNode(7);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        String codeced = codec.serialize(one);
        assertEquals("1,2,4,5,3,6,7:4,2,5,1,6,3,7", codeced);
        assertEquals("1,2,4,5,3,6,7:4,2,5,1,6,3,7",
                codec.serialize(codec.deserialize(codeced)));
    }

}