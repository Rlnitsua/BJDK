package com.lizbyu.utils;

import com.lizbyu.tree.binary.BinaryTree;
import com.lizbyu.utils.BinaryTrees;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class BinaryTreesTestFromIP {
    private Integer[] inorder;
    private Integer[] postorder;
    private List<Integer> nodeList;
    private BinaryTrees<Integer> binaryTrees;

    public BinaryTreesTestFromIP(Integer[] inorder, Integer[] postorder, List<Integer> nodeList) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.nodeList = nodeList;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> preparData() {
        return Arrays.asList(new Object[][]{
                {
                    new Integer[]{2, 1, 3}, new Integer[]{2, 3, 1}, Arrays.asList(1, 2, 3)
                },
                {
                        new Integer[]{9, 3, 15, 20, 7}, new Integer[]{9, 15, 7, 20, 3},
                        Arrays.asList(3, 9, 20, null, null, 15, 7)
                },
                {
                        new Integer[]{8, 2, 11, 9, 1, 27, 3, 4},
                        new Integer[]{8, 11, 9, 2, 3, 27, 4, 1},
                        Arrays.asList(1, 2, 4, 8, 9, 27, null, null, null, 11, null, null, 3)
                }
        });
    }

    @Before
    public void setUp() throws Exception {
        binaryTrees = new BinaryTrees<>();
    }

    @Test
    public void createFromIP() {
        BinaryTree<Integer, BinaryTree.Node<Integer>> p = binaryTrees.createFromIP(inorder, postorder);
        BinaryTree<Integer, BinaryTree.Node<Integer>> q = binaryTrees.create(nodeList);
        Assert.assertTrue(binaryTrees.isSameTree(p, q));
    }
}