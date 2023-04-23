package com.internship.openx.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


import java.util.Objects;

@NoArgsConstructor
public class TreeNode {
    @Getter
    private int value;

    @Getter
    @Setter
    private TreeNode rightChild;

    @Getter
    @Setter
    private TreeNode leftChild;

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TreeNode)) return false;
        TreeNode otherNode = (TreeNode) obj;
        return this.value == otherNode.value &&
                Objects.equals(this.leftChild, otherNode.leftChild) &&
                Objects.equals(this.rightChild, otherNode.rightChild);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + value;
        hash = 31 * hash + (leftChild == null ? 0 : leftChild.hashCode());
        hash = 31 * hash + (rightChild == null ? 0 : rightChild.hashCode());
        return hash;
    }

}