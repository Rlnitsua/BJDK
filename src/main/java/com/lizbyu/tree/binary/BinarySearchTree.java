package com.lizbyu.tree.binary;

@SuppressWarnings("unused")
public class BinarySearchTree extends BinaryTree {

    public BinarySearchTree(Node<Integer> root) {
        super(root);
    }

    public boolean insert(int val) {
        Node insertRes = insert(root, val);
        return insertRes != null;
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

    public boolean search(int val) {
        Node res = search(root, val);
        return res != null;
    }

    private Node<Integer> search(Node<Integer> node, int val) {
        if (node == null || node.getVal() == val) {
            return node;
        }

        if (val > node.getVal()) {
            return search(node.getRight(), val);
        } else {
            return search(node.getLeft(), val);
        }
    }

    public void remove(int val) {
        root = remove(root, val);
    }

    private Node<Integer> remove(Node<Integer> currentNode, int val) {
        if (currentNode == null) {
            return null;
        }

        if (val > currentNode.getVal()) {
            currentNode.setRight(remove(currentNode.getRight(), val));
        } else if (val < currentNode.getVal()) {
            currentNode.setLeft(remove(currentNode.getLeft(), val));
        } else {
            // contains 1) left==null && right != null 2) left==null && right==null
            if (currentNode.getLeft() == null) {
                return currentNode.getRight();
            } else if (currentNode.getRight() == null) {
                return currentNode.getLeft();
            } else {
                Node<Integer> postNode = getPostNode(currentNode.getRight());
                currentNode.setV(postNode.getVal());
                currentNode.setRight(remove(currentNode.getRight(), postNode.getVal()));
            }
        }

        return currentNode;
    }

    private Node<Integer> getPostNode(Node<Integer> currentNode) {
        Node<Integer> postNode;
        if (currentNode.getLeft() != null) {
            postNode = getPostNode(currentNode.getLeft());
        } else {
            postNode = currentNode;
        }
        return postNode;
    }

}
