package com.lizbyu.tree.binary;

import com.lizbyu.utils.BinaryTrees;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BinarySearchTreeTestRemove {
    private List<Integer> nodeList;
    private int val;
    private List<Integer> resList;

    public BinarySearchTreeTestRemove(List<Integer> nodeList, int val, List<Integer> resList) {
        this.nodeList = nodeList;
        this.val = val;
        this.resList = resList;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(2, 1, 3), 1, Arrays.asList(2, null, 3)},
                {Arrays.asList(5, 2, 9, 1, 3), 1, Arrays.asList(5, 2, 9, null, 3)},
                {Arrays.asList(5, 2, 9, 1, 3), 3, Arrays.asList(5, 2, 9, 1)},
                {Arrays.asList(5, 2, 9, 1, 3), 2, Arrays.asList(5, 3, 9, 1)}
        });
    }

    @Test
    public void remove() {
        BinaryTrees<Integer> trees = new BinaryTrees<>();
        BinaryTree<Integer, BinaryTree.Node<Integer>> binaryTree = trees.create(nodeList);
        BinarySearchTree bst = new BinarySearchTree(binaryTree.getRoot());
        bst.remove(val);
        assertTrue(trees.isSameTree(bst, trees.create(resList)));
    }
}