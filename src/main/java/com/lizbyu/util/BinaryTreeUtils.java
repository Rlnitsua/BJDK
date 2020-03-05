package com.lizbyu.util;

import com.lizbyu.tree.BinaryTree;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeUtils<V> {

    public BinaryTree<V, BinaryTree.Node<V>> create(List<V> valueSequence) {
        return new BinaryTree<>(createRootNode(valueSequence, 0));
    }

    private BinaryTree.Node<V> createRootNode(List<V> valueSequence, int index) {
        if (index >= valueSequence.size() || valueSequence.get(index) == null) {
            return null;
        }

        BinaryTree.Node<V> node = new BinaryTree.Node<>(valueSequence.get(index));
        node.setLeft(createRootNode(valueSequence, 2 * index + 1));
        node.setRight(createRootNode(valueSequence, 2 * index + 2));
        return node;
    }

    /**
     * Note : You may assume that duplicates do not exist in the tree.
     */
    public BinaryTree<V, BinaryTree.Node<V>> create(V[] preorder, V[]inorder) {
        return new BinaryTree<>(createRootNode(preorder, inorder));
    }

    private BinaryTree.Node<V> createRootNode(V[] preorder, V[]inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        V rootVal = preorder[0];
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        // pre : rootval -- [left] -- [right]
        // in : [left] -- rootval -- [right]
        BinaryTree.Node<V> node = new BinaryTree.Node<>(rootVal);

        V[] leftPreorder = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        V[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        node.setLeft(createRootNode(leftPreorder, leftInorder));

        V[] rightPreorder = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
        V[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        node.setRight(createRootNode(rightPreorder, rightInorder));

        return node;
    }

    public boolean isSameTree(BinaryTree.Node<V> p, BinaryTree.Node<V> q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        } else if (p.getVal() != q.getVal()) {
            return false;
        }

        if (p.getLeft() == null && p.getRight() == null && q.getLeft() == null
        && q.getRight() == null) {
            return true;
        }

        return isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());
    }


}
