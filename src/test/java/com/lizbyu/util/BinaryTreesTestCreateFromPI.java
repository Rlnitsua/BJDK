package com.lizbyu.util;

import com.lizbyu.tree.binary.BinaryTree;
import com.lizbyu.utils.BinaryTrees;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BinaryTreesTestCreateFromPI {
    private Integer[] preorder;
    private Integer[] inorder;
    private List<Integer> treeNode;
    private static BinaryTrees<Integer> binaryTrees;

    public BinaryTreesTestCreateFromPI(Integer[] preorder, Integer[] inorder, List<Integer> treeNode) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.treeNode = treeNode;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {
                    new Integer[]{1, 2, 3}, new Integer[]{2, 1, 3}, Arrays.asList(1, 2, 3)
                },
                {
                        new Integer[]{3, 9, 20, 15, 7}, new Integer[]{9, 3, 15, 20, 7},
                        Arrays.asList(3, 9, 20, null, null, 15, 7)
                },
                {
                        new Integer[]{1, 2, 8, 9, 11, 4, 27, 3},
                        new Integer[]{8, 2, 11, 9, 1, 27, 3, 4},
                        Arrays.asList(1, 2, 4, 8, 9, 27, null, null, null, 11, null, null, 3)
                }
        });
    }

    @BeforeClass
    public static void setUp() {
        System.out.println("setup");
        binaryTrees = new BinaryTrees<>();
    }

    @Test
    public void create() {
        BinaryTree<Integer, BinaryTree.Node<Integer>> p = binaryTrees.createFromPI(preorder, inorder);
        BinaryTree<Integer, BinaryTree.Node<Integer>> q = binaryTrees.create(treeNode);
        assertTrue(binaryTrees.isSameTree(p.getRoot(), q.getRoot()));
    }
}