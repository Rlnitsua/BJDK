package com.lizbyu.util;

import com.lizbyu.tree.BinaryTree;

import java.util.List;

public class BinaryTreeFactory<V> {

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
}
