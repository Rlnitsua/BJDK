package com.lizbyu.tree;

import org.junit.Assert;
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
        TreeNodeHandler treeNodeHandler = new TreeNodeHandler();
        binaryTree.preorderTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "123");
    }

    @Test
    public void inorderTraversal() {
        System.out.println("\nin order traversal");
        TreeNodeHandler treeNodeHandler = new TreeNodeHandler();
        binaryTree.inorderTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "213");
    }

    @Test
    public void postorderTraversal() {
        System.out.println("\npost order traversal");
        TreeNodeHandler treeNodeHandler = new TreeNodeHandler();
        binaryTree.postorderTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "231");
    }

    @Test
    public void levelTraversal() {
        TreeNodeHandler treeNodeHandler = new TreeNodeHandler();
        binaryTree.levelTraversal(treeNodeHandler);
    }
}