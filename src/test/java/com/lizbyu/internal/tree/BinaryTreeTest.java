package com.lizbyu.internal.tree;

import com.lizbyu.internal.tree.binary.BinaryTree;
import com.lizbyu.internal.utils.BinaryTrees;
import com.lizbyu.internal.utils.LogUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeTest {
    private static final String TAG = "BinaryTreeTest";
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
        BinaryTrees<Integer> binaryTrees = new BinaryTrees<>();
        binaryTree = binaryTrees.create(Arrays.asList(1, 2, 4, 8, 9, 27, null, null, null, 11, null, null, 3));
    }

    @Test
    public void preorderTraversal() {
        LogUtils.d(TAG, "pre order traversal");
        TreeNodeHandler<Integer, BinaryTree.Node<Integer>> treeNodeHandler = new TreeNodeHandler<>();
        binaryTree.preorderTraversal(treeNodeHandler);
        Assert.assertEquals("1289114273", treeNodeHandler.signedTag());
    }

    @Test
    public void inorderTraversal() {
        LogUtils.d(TAG, "in order traversal");
        TreeNodeHandler<Integer, BinaryTree.Node<Integer>> treeNodeHandler = new TreeNodeHandler<>();
        binaryTree.inorderTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "8211912734");
    }

    @Test
    public void postorderTraversal() {
        LogUtils.d(TAG, "post order traversal");
        TreeNodeHandler<Integer, BinaryTree.Node<Integer>> treeNodeHandler = new TreeNodeHandler<>();
        binaryTree.postorderTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "8119232741");
    }

    @Test
    public void levelTraversal() {
        LogUtils.d(TAG, "level order traversal");
        TreeNodeHandler<Integer, BinaryTree.Node<Integer>> treeNodeHandler = new TreeNodeHandler<>();
        binaryTree.levelTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "1248927113");
    }

    @Test
    public void levelTraversal0() {
        LogUtils.d(TAG, "level order traversal0");
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
        LogUtils.d(TAG, "invert binary tree");
        binaryTree.invert();

        TreeNodeHandler<Integer, BinaryTree.Node<Integer>> treeNodeHandler = new TreeNodeHandler<>();

        LogUtils.d(TAG, "pre order traversal");
        binaryTree.preorderTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "1427329118");
        treeNodeHandler.reset();

        LogUtils.d(TAG, "inorder traversal");
        binaryTree.inorderTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "4327191128");
        treeNodeHandler.reset();

        LogUtils.d(TAG, "post order traversal");
        binaryTree.postorderTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "3274119821");
        treeNodeHandler.reset();

        LogUtils.d(TAG, "level traversal");
        binaryTree.levelTraversal(treeNodeHandler);
        Assert.assertEquals(treeNodeHandler.signedTag(), "1422798311");
    }

    @Test
    public void deep() {
        Assert.assertEquals(binaryTree.deep(), 4);
    }
}