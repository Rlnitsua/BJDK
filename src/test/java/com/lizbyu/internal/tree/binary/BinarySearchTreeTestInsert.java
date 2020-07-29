package com.lizbyu.internal.tree.binary;

import com.lizbyu.internal.utils.BinaryTrees;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BinarySearchTreeTestInsert {
    private final List<Integer> nodeList;
    private final int insertVal;
    private final List<Integer> afterInsertNodeList;

    public BinarySearchTreeTestInsert(List<Integer> nodeList, int insertVal, List<Integer> afterInsertNodeList) {
        this.nodeList = nodeList;
        this.insertVal = insertVal;
        this.afterInsertNodeList = afterInsertNodeList;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(4, 2, 6, 1, null, null, 7), 3, Arrays.asList(4, 2, 6, 1, 3, null, 7)},
                {Arrays.asList(4, 2, 6, 1, null, null, 7), 5, Arrays.asList(4, 2, 6, 1, null, 5, 7)},
                {Arrays.asList(4, 2, 6, 1, 3, null, 7), 5, Arrays.asList(4, 2, 6, 1, 3, 5, 7)},
                {Arrays.asList(4, 2, 6, 1, null, 5, 7), 3, Arrays.asList(4, 2, 6, 1, 3, 5, 7)}
        });
    }

    @Test
    public void insert() {
        BinaryTrees<Integer> binaryTrees = new BinaryTrees<>();
        BinarySearchTree binarySearchTree = new BinarySearchTree(binaryTrees.create(nodeList).getRoot());
        binarySearchTree.insert(insertVal);
        BinaryTree<Integer, BinaryTree.Node<Integer>> tree = binaryTrees.create(afterInsertNodeList);
        assertTrue(binaryTrees.isSameTree(binarySearchTree, tree));
    }
}