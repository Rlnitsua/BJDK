package com.lizbyu.utils;

import com.lizbyu.tree.binary.BinarySearchTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BinaryTreesTestBST {
    private List<Integer> nodeList;
    private boolean isBST;

    public BinaryTreesTestBST(List<Integer> nodeList, boolean isBST) {
        this.nodeList = nodeList;
        this.isBST = isBST;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(1), true},
                {Arrays.asList(1, 2, 3, 4, 5, 6), false},
                {Arrays.asList(4, 2, 6, 1, null, null, 7), true},
        });
    }

    @Test
    public void isBST() {
        BinaryTrees<Integer> binaryTrees = new BinaryTrees<>();
        BinarySearchTree bst = new BinarySearchTree(binaryTrees.create(nodeList).getRoot());
        assertEquals(binaryTrees.isBST(bst), isBST);
    }
}