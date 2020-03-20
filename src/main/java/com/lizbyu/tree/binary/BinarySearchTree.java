package com.lizbyu.tree.binary;

@SuppressWarnings("unused")
public class BinarySearchTree extends BinaryTree {

    public BinarySearchTree(Node<Integer> root) {
        super(root);
    }

    public boolean insert(int val) {
        Node insertRes = insert(root, val);
        return insertRes == null;
    }

    private Node<Integer> insert(Node<Integer> node, int val) {
        if (node == null) {
            node = new Node<>(val);
            return node;
        }

        if (val > node.getVal()) {
            node.setRight(insert(node.getRight(), val));
        } else {
            node.setLeft(insert(node.getLeft(), val));
        }
        return node;
    }

}
