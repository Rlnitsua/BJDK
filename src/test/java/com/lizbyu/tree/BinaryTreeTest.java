package com.lizbyu.tree;

import com.lizbyu.tree.binary.BinaryTree;
import com.lizbyu.tree.binary.BinaryTrees;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeTest {
    private BinaryTrees<Integer> binaryTrees;
    private BinaryTree<Integer, BinaryTree.Node<Integer>> binaryTree;

    /**
     *          1
     *        /   \
     *       2     4
     *      / \   /
     *     8  9  27
     *       /    \
     *     11     3
     */
    @Before
    public void setUp() {
        binaryTrees = new BinaryTrees<>();
        binaryTree = binaryTrees.create(Arrays.asList(1, 2, 4, 8, 9, 27, null, null, null, 11, null, null, 3));
    }

    @Test
    public void preorderTraversal() {
        System.out.println("\npre order traversal");
        TreeNodeHandler treeNodeHandler = new TreeNodeHandler();
        binaryTree.preorderTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "1289114273");
    }

    @Test
    public void inorderTraversal() {
        System.out.println("\nin order traversal");
        TreeNodeHandler treeNodeHandler = new TreeNodeHandler();
        binaryTree.inorderTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "8211912734");
    }

    @Test
    public void postorderTraversal() {
        System.out.println("\npost order traversal");
        TreeNodeHandler treeNodeHandler = new TreeNodeHandler();
        binaryTree.postorderTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "8119232741");
    }

    @Test
    public void levelTraversal() {
        System.out.println("\nlevel traversal");
        TreeNodeHandler treeNodeHandler = new TreeNodeHandler();
        binaryTree.levelTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "1248927113");
    }

    @Test
    public void levelTraversal0() {
        System.out.println("\nlevel traversal0");
        TreeNodeHandler<Integer, BinaryTree.Node<Integer>> treeNodeHandler = new TreeNodeHandler<>();

        List<List<Integer>> list = binaryTree.levelTraversal0(treeNodeHandler);
        // pre order list
        Assert.assertEquals(treeNodeHandler.signedTag(), "1289114273");
        Assert.assertArrayEquals(list.get(0).toArray(new Integer[0]), new Integer[]{1});
        Assert.assertArrayEquals(list.get(1).toArray(new Integer[0]), new Integer[]{2, 4});
        Assert.assertArrayEquals(list.get(2).toArray(new Integer[0]), new Integer[]{8, 9, 27});
        Assert.assertArrayEquals(list.get(3).toArray(new Integer[0]), new Integer[]{11, 3});
    }

    @Test
    public void invert() {
        System.out.println("\ninvert binary tree");
        binaryTree.invert();

        TreeNodeHandler treeNodeHandler = new TreeNodeHandler();

        System.out.println("\npre order traversal");
        binaryTree.preorderTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "1427329118");
        treeNodeHandler.reset();

        System.out.println("\ninorder traversal");
        binaryTree.inorderTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "4327191128");
        treeNodeHandler.reset();

        System.out.println("\npost order traversal");
        binaryTree.postorderTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "3274119821");
        treeNodeHandler.reset();

        System.out.println("\nleveltraversal");
        binaryTree.levelTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "1422798311");
    }

    @Test
    public void deep() {
        Assert.assertEquals(binaryTree.deep(), 4);
    }
}