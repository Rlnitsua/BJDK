package com.lizbyu.util;

import com.lizbyu.tree.BinaryTree;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BinaryTreeUtilsTest {
    private BinaryTreeUtils<Integer> binaryTreeUtils;
    private List<Integer> list;

    public BinaryTreeUtilsTest(List list) {
        this.list = list;
    }

    @Parameterized.Parameters(name = "{index} : {0}")
    public static Iterable<List> preparedData() {
        List[] obj = {
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(3, null, 3, 4, 5),
                Arrays.asList(15, 2, 3, null, 5),
                Arrays.asList(1, 22, null, 34, 5)
        };
        return Arrays.asList(obj);
    }

    @Before
    public void setUp() throws Exception {
        binaryTreeUtils = new BinaryTreeUtils<>();
    }

    @Test
    public void isSameTree() {
        BinaryTree<Integer, BinaryTree.Node<Integer>> tree0 = binaryTreeUtils.create(list);
        BinaryTree<Integer, BinaryTree.Node<Integer>> tree1 = binaryTreeUtils.create(list);
        assertTrue(binaryTreeUtils.isSameTree(tree0.getRoot(), tree1.getRoot()));
    }
}