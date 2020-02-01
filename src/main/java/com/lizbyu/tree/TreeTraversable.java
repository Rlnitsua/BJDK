package com.lizbyu.tree;

import com.lizbyu.lang.Node;
import com.lizbyu.lang.NodeHandler;
import com.lizbyu.lang.Traversable;

public interface TreeTraversable<V, N extends Node<V>> extends Traversable {
    /**
     * In this traversal method, the root is visited first
     * then the left sub-tree, and later the right sub-tree.
     */
    void preorderTraversal(NodeHandler<N> handle);

    /**
     * In this traversal method, the left sub-tree is visited first
     * then the root sub-tree, and later the right sub-tree
     */
    void inorderTraversal(NodeHandler<N> handle);

    /**
     * In this traversal method, the left sub-tree is visited first
     * then the right sub-tree, and later the root
     */
    void postorderTraversal(NodeHandler<N> handle);

    /**
     * In this traversal method, all nodes at depth "x" are visited
     * before any node at depth "x+1"
     */
    void levelTraversal();
}
