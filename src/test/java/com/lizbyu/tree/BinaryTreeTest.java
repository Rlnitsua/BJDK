package com.lizbyu.tree;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {
    private BinaryTree<Integer, BinaryTree.Node<Integer>> binaryTree;

    @Before
    public void setUp() {
        BinaryTree.Node<Integer> root = initRoot();
        binaryTree = new BinaryTree<>(root);
    }

    /**
     *    1
     *   / \
     *  2  3
     */
    private BinaryTree.Node<Integer> initRoot() {
        BinaryTree.Node<Integer> root = new BinaryTree.Node<>(1);
        BinaryTree.Node<Integer> left = new BinaryTree.Node<>(2);
        BinaryTree.Node<Integer> right = new BinaryTree.Node<>(3);
        root.setLeft(left);
        root.setRight(right);
        return root;
    }

    @Test
    public void preorderTraversal() {
        System.out.println("\npre order traversal");
        binaryTree.preorderTraversal(new TreeNodeHandler());
    }

    @Test
    public void inorderTraversal() {
        System.out.println("\nin order traversal");
        binaryTree.inorderTraversal(new TreeNodeHandler());
    }

    @Test
    public void postorderTraversal() {
        System.out.println("\npost order traversal");
        binaryTree.postorderTraversal(new TreeNodeHandler());
    }
}