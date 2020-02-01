package com.lizbyu.tree;

import com.lizbyu.lang.Node;
import com.lizbyu.lang.NodeHandler;

public class TreeNodeHandler<V, N extends Node<V>> implements NodeHandler<N> {
    @Override
    public void handle(N node) {
        System.out.print(node.getVal() + " - ");
    }
}
