import com.internship.openx.model.Tree;
import com.internship.openx.model.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreeNodeTest {

    @Test
    void testEquals() {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(5);
        assertEquals(t1, t2);

        t1.setLeftChild(new TreeNode(3));
        assertNotEquals(t1, t2);

        t2.setLeftChild(new TreeNode(3));
        assertEquals(t1, t2);

        t1.setRightChild(new TreeNode(7));
        assertNotEquals(t1, t2);

        t2.setRightChild(new TreeNode(7));
        assertEquals(t1, t2);

        t1.getRightChild().setLeftChild(new TreeNode(6));
        assertNotEquals(t1, t2);

        t2.getRightChild().setLeftChild(new TreeNode(6));
        assertEquals(t1, t2);
    }



    @Test
    public void testEquals_NullAndNotNull_shouldBeNotEqual() {
        Tree tree1 = new Tree(null);
        Tree tree2 = new Tree(new TreeNode(1));

        assertNotEquals(tree1, tree2);
    }
    @Test
    void testEquals_whenOneNode_shouldBeEqual() {
        TreeNode head1 = new TreeNode(0);
        TreeNode head2 = new TreeNode(0);
        assertEquals(head1, head2);
    }
    @Test
    void testHashCode_whenDifferentStructure_shouldBeNotEqual() {
        TreeNode t1 = new TreeNode(5);
        t1.setLeftChild(new TreeNode(3));
        t1.setRightChild(new TreeNode(7));

        TreeNode t2 = new TreeNode(5);
        t2.setLeftChild(new TreeNode(3));
        t2.getLeftChild().setLeftChild(new TreeNode(2));
        t2.setRightChild(new TreeNode(7));

        assertNotEquals(t1.hashCode(), t2.hashCode());
    }
    @Test
    void testHashCode() {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(5);
        assertEquals(t1.hashCode(), t2.hashCode());

        t1.setLeftChild(new TreeNode(3));
        assertNotEquals(t1.hashCode(), t2.hashCode());

        t2.setLeftChild(new TreeNode(3));
        assertEquals(t1.hashCode(), t2.hashCode());

        t1.setRightChild(new TreeNode(7));
        assertNotEquals(t1.hashCode(), t2.hashCode());

        t2.setRightChild(new TreeNode(7));
        assertEquals(t1.hashCode(), t2.hashCode());

        t1.getRightChild().setLeftChild(new TreeNode(6));
        assertNotEquals(t1.hashCode(), t2.hashCode());

        t2.getRightChild().setLeftChild(new TreeNode(6));
        assertEquals(t1.hashCode(), t2.hashCode());
    }
}
