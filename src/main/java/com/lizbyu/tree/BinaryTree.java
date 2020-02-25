package com.lizbyu.tree;

import com.lizbyu.lang.Node;
import com.lizbyu.lang.NodeHandler;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary tree implements
 * A tree-like structure that is rooted and in which each vertex
 * has at most two children and each of a vertex is designed at its
 * left or right child.
 * @param <V> val type
 */
public class BinaryTree<V, N extends Node<V>> extends Tree {
    private Node<V> root;

    public BinaryTree(Node<V> root) {
        this.root = root;
    }

    public Node<V> getRoot() {
        return root;
    }

    public void setRoot(Node<V> root) {
        this.root = root;
    }

    /**
     * Basic binary tree node
     */
    public static class Node<V> extends com.lizbyu.lang.Node<V> {
        private Node<V> left;
        private Node<V> right;

        public Node(V val) {
            super(val);
        }

        public Node(V val, Node<V> left, Node<V> right) {
            super(val);
            this.left = left;
            this.right = right;
        }

        public Node<V> getLeft() {
            return left;
        }

        public void setLeft(Node<V> left) {
            this.left = left;
        }

        public Node<V> getRight() {
            return right;
        }

        public void setRight(Node<V> right) {
            this.right = right;
        }
    }

    @Override
    public void preorderTraversal(NodeHandler handler) {
        preorderTraversal(root, handler);
    }

    private void preorderTraversal(Node<V> root, NodeHandler<Node<V>> handler) {
        if (root == null) {
            return;
        }

        handler.handle(root);
        preorderTraversal(root.left, handler);
        preorderTraversal(root.right, handler);
    }

    @Override
    public void inorderTraversal(NodeHandler handler) {
        inorderTraversal(root, handler);
    }

    private void inorderTraversal(Node<V> root, NodeHandler<Node<V>> handler) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, handler);
        handler.handle(root);
        inorderTraversal(root.right, handler);
    }

    @Override
    public void postorderTraversal(NodeHandler handler) {
        postorderTraversal(root, handler);
    }

    private void postorderTraversal(Node<V> root, NodeHandler<Node<V>> handler) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left, handler);
        postorderTraversal(root.right, handler);
        handler.handle(root);
    }

    @Override
    public void levelTraversal(NodeHandler handler) {
        Queue<Node<V>> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node<V> poll = queue.poll();
            handler.handle(poll);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }
}
