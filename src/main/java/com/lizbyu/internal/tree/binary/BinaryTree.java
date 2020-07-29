package com.lizbyu.internal.tree.binary;

import com.lizbyu.internal.tree.NodeHandler;
import com.lizbyu.internal.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary tree implements
 * A tree-like structure that is rooted and in which each vertex
 * has at most two children and each of a vertex is designed at its
 * left or right child.
 * @param <V> val type
 */
public class BinaryTree<V, N extends BinaryTree.Node<V>> extends Tree<V, N> {
    protected N root;

    public BinaryTree(N root) {
        this.root = root;
    }

    public N getRoot() {
        return root;
    }

    /**
     * Basic binary tree node
     */
    public static class Node<V> extends com.lizbyu.internal.tree.Node<V> {
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

        public void setV(V v) {
            super.val = v;
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
    public void preorderTraversal(NodeHandler<N> handler) {
        preorderTraversal(root, handler);
    }

    @SuppressWarnings("unchecked")
    private void preorderTraversal(N root, NodeHandler<N> handler) {
        if (root == null) {
            return;
        }

        handler.handle(root);
        preorderTraversal((N) root.getLeft(), handler);
        preorderTraversal((N) root.getRight(), handler);
    }

    @Override
    public void inorderTraversal(NodeHandler<N> handler) {
        inorderTraversal(root, handler);
    }

    @SuppressWarnings("unchecked")
    private void inorderTraversal(N root, NodeHandler<N> handler) {
        if (root == null) {
            return;
        }

        inorderTraversal((N) root.getLeft(), handler);
        handler.handle(root);
        inorderTraversal((N) root.getRight(), handler);
    }

    @Override
    public void postorderTraversal(NodeHandler<N> handler) {
        postorderTraversal(root, handler);
    }

    @SuppressWarnings("unchecked")
    private void postorderTraversal(N root, NodeHandler<N> handler) {
        if (root == null) {
            return;
        }

        postorderTraversal((N) root.getLeft(), handler);
        postorderTraversal((N) root.getRight(), handler);
        handler.handle(root);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void levelTraversal(NodeHandler<N> handler) {
        Queue<Node<V>> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node<V> poll = queue.poll();
            handler.handle((N) poll);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }

    public List<List<V>> levelTraversal0(NodeHandler<Node<V>> handler) {
        List<List<V>> list = new ArrayList<>();
        levelTraversal(root, list, 0, handler);
        return list;
    }

    private void levelTraversal(Node<V> node, List<List<V>> list, int level, NodeHandler<Node<V>> handler) {
        if (node == null) {
            return;
        }

        if (list.size() <= level) {
            List<V> element = new ArrayList<>();
            list.add(element);
        }

        List<V> currentElement = list.get(level);
        currentElement.add(node.getVal());
        handler.handle(node);

        levelTraversal(node.left, list, level + 1, handler);
        levelTraversal(node.right, list, level + 1, handler);
    }

    public void invert() {
        invert(root);
    }

    private void invert(Node<V> node) {
        if (node == null) {
            return;
        }

        // invert node
        Node<V> temp = node.left;
        node.left = node.right;
        node.right = temp;

        // the same thing to left node and right node
        invert(node.left);
        invert(node.right);
    }

    public int deep() {
        return deep(root);
    }

    private int deep(Node<V> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(deep(node.left), deep(node.right)) + 1;
    }

    public boolean isSymmetric() {
        if (root == null) {
            return true;
        }
        return isSymmetricPair(root.getLeft(), root.getRight());
    }

    private boolean isSymmetricPair(Node<V> p, Node<V> q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        } else if (p.getVal() != q.getVal()) {
            return false;
        }

        return isSymmetricPair(p.getLeft(), q.getRight())
                && isSymmetricPair(p.getRight(), q.getLeft());
    }


}
