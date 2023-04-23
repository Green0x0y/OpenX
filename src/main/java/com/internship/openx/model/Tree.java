package com.internship.openx.model;

import lombok.Getter;

import java.util.Objects;

public class Tree {
    @Getter
    private final TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public int getLeavesNumber() {
        return countLeaves(root);
    }


    private int countLeaves(TreeNode currentNode) {
        if (currentNode == null) {  // base case: empty node
            return 0;
        }
        if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {  // base case: leaf node
            return 1;
        }
        // recursive case: count leaves in the left and right subtrees
        return countLeaves(currentNode.getLeftChild()) + countLeaves(currentNode.getRightChild());
    }


    private int rootToLeafMax(TreeNode node) {
        if (node == null) {
            return 0; // an empty tree has no path
        }
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return 0; // a leaf node has no edges on the path
        }
        int leftPathLength = rootToLeafMax(node.getLeftChild());
        int rightPathLength = rootToLeafMax(node.getRightChild());
        return Math.max(leftPathLength, rightPathLength) + 1; // add the edge connecting the current node to the longer path
    }


    public int getRootToLeafMax() {
        return rootToLeafMax(root);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Tree otherTree)) {
            return false;
        }
        return Objects.equals(otherTree.root, this.root);
    }

    @Override
    public int hashCode() {
        int hash = 17; // initialize the hash with a prime number
        hash = 31 * hash + (root == null ? 0 : root.hashCode()); // calculate hash code based on the root node
        return hash; // return the calculated hash code
    }
}
