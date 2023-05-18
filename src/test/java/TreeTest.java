import static org.junit.jupiter.api.Assertions.assertEquals;

import com.internship.openx.model.Tree;
import com.internship.openx.model.TreeNode;
import org.junit.jupiter.api.Test;

class TreeTest {

    @Test
    public void testEmptyTree() {
        Tree emptyTree = new Tree(null);
        assertEquals(0, emptyTree.getLeavesNumber());
        assertEquals(0, emptyTree.getRootToLeafMax());
    }

    @Test
    void testCountLeavesSingleLeafTree() {
        TreeNode leafNode = new TreeNode(5);
        Tree singleLeafTree = new Tree(leafNode);
        assertEquals(1, singleLeafTree.getLeavesNumber());
    }

    @Test
    void testCountLeavesTwoLeavesTree() {
        TreeNode leftChild = new TreeNode(2);
        TreeNode rightChild = new TreeNode(3);
        TreeNode rootNode = new TreeNode(1);
        rootNode.setLeftChild(leftChild);
        rootNode.setRightChild(rightChild);
        Tree twoLeavesTree = new Tree(rootNode);
        assertEquals(2, twoLeavesTree.getLeavesNumber());
    }

    @Test
    void testCountLeavesThreeLeavesTree() {
        TreeNode leftChild = new TreeNode(2);
        TreeNode leftChildLeftChild = new TreeNode(4);
        TreeNode leftChildRightChild = new TreeNode(5);
        TreeNode rightChild = new TreeNode(3);
        TreeNode rootNode = new TreeNode(1);
        leftChild.setLeftChild(leftChildLeftChild);
        leftChild.setRightChild(leftChildRightChild);
        rootNode.setLeftChild(leftChild);
        rootNode.setRightChild(rightChild);
        Tree threeLeavesTree = new Tree(rootNode);
        assertEquals(3, threeLeavesTree.getLeavesNumber());
    }
    @Test
    public void testrootToLeafMax() {
        // create a sample tree with the longest path length of 4
        TreeNode root = new TreeNode(1);
        root.setLeftChild(new TreeNode(2));
        root.getLeftChild().setLeftChild(new TreeNode(4));
        root.getLeftChild().getLeftChild().setLeftChild(new TreeNode(7));
        root.getLeftChild().getLeftChild().getLeftChild().setRightChild(new TreeNode(8));
        root.setRightChild(new TreeNode(3));
        root.getRightChild().setLeftChild(new TreeNode(5));
        root.getRightChild().setRightChild(new TreeNode(6));
        Tree tree = new Tree(root);
        assertEquals(4, tree.getRootToLeafMax());
    }
    @Test
    public void testrootToLeafMax_singleLeaf() {
        TreeNode root = new TreeNode(1);
        Tree tree = new Tree(root);
        assertEquals(0, tree.getRootToLeafMax());
    }
    @Test
    public void testrootToLeafMax_singleNodeWithTwoLeaves() {
        TreeNode root = new TreeNode(1);
        root.setLeftChild(new TreeNode(2));
        root.setRightChild(new TreeNode(3));
        Tree tree = new Tree(root);
        assertEquals(1, tree.getRootToLeafMax());
    }
    @Test
    public void testrootToLeafMax_twoNodesWithOneLeafEach() {
        TreeNode root = new TreeNode(1);
        root.setLeftChild(new TreeNode(2));
        Tree tree = new Tree(root);
        assertEquals(1, tree.getRootToLeafMax());
    }
    @Test
    public void testrootToLeafMax_symmetricTree() {
        TreeNode root = new TreeNode(1);
        root.setLeftChild(new TreeNode(2));
        root.setRightChild(new TreeNode(2));
        root.getLeftChild().setLeftChild(new TreeNode(3));
        root.getLeftChild().setRightChild(new TreeNode(4));
        root.getRightChild().setLeftChild(new TreeNode(4));
        root.getRightChild().setRightChild(new TreeNode(3));
        Tree tree = new Tree(root);
        assertEquals(2, tree.getRootToLeafMax());
    }
    @Test
    public void testrootToLeafMax_asymmetricTree() {
        TreeNode root = new TreeNode(1);
        root.setLeftChild(new TreeNode(2));
        root.getLeftChild().setRightChild(new TreeNode(3));
        root.getLeftChild().getRightChild().setLeftChild(new TreeNode(4));
        root.getLeftChild().getRightChild().setRightChild(new TreeNode(5));
        Tree tree = new Tree(root);
        assertEquals(3, tree.getRootToLeafMax());
    }


    @Test
    public void testEqualsAndHashCode() {
        // create two identical trees
        TreeNode root1 = new TreeNode(1);
        root1.setLeftChild(new TreeNode(2));
        root1.setRightChild(new TreeNode(3));
        TreeNode root2 = new TreeNode(1);
        root2.setLeftChild(new TreeNode(2));
        root2.setRightChild(new TreeNode(3));
        Tree tree1 = new Tree(root1);
        Tree tree2 = new Tree(root2);
        // test that they are equal and have the same hash code
        assertEquals(tree1, tree2);
        assertEquals(tree1.hashCode(), tree2.hashCode());
    }
}
