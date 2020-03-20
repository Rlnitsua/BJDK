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
public class BinarySearchTreeTestSearch {
    private List<Integer> nodeList;
    private int val;
    private boolean isExist;

    public BinarySearchTreeTestSearch(List<Integer> nodeList, int val, boolean isExist) {
        this.nodeList = nodeList;
        this.val = val;
        this.isExist = isExist;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(4, 2, 6, 1, null, null, 7), 1, true},
                {Arrays.asList(4, 2, 6, 1, null, null, 7), 3, false},
                {Arrays.asList(4, 2, 6, 1, null, null, 7), 4, true},
                {Arrays.asList(4, 2, 6, 1, null, null, 7), 2, true},
                {Arrays.asList(4, 2, 6, 1, null, null, 7), 5, false},
        });
    }

    @Test
    public void search() {
        BinaryTrees<Integer> binaryTrees = new BinaryTrees<>();
        BinarySearchTree bst = new BinarySearchTree(binaryTrees.create(nodeList).root);
        assertEquals(bst.search(val), isExist);
    }
}