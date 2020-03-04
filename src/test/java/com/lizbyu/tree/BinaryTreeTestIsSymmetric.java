package com.lizbyu.tree;

import com.lizbyu.util.BinaryTreeUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BinaryTreeTestIsSymmetric {
    private List<Integer> list;
    private boolean isSymmetric;
    private BinaryTreeUtils<Integer> binaryTreeUtils;

    public BinaryTreeTestIsSymmetric(List<Integer> list, boolean isSymmetric) {
        this.list = list;
        this.isSymmetric = isSymmetric;
    }

    @Parameterized.Parameters(name = "{index} : {0} - {1}")
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                { Arrays.asList(1, 2, 3, 4), false},
                { Arrays.asList(1, 2, 2, 3, 4, 4, 3), true},
                { Arrays.asList(1, 2, 2, null, 3, null, 3), false},
                { Arrays.asList(1, 2, 3, 3, null, null, 3), false},
                { Arrays.asList(1, 2, 2, 3, null, null, 3), true}
        });
    }

    @Before
    public void setUp() {
        binaryTreeUtils = new BinaryTreeUtils<>();
    }

    @Test
    public void isSymmetric() {
        BinaryTree<Integer, BinaryTree.Node<Integer>> tree = binaryTreeUtils.create(list);
        assertEquals(tree.isSymmetric(), isSymmetric);
    }
}