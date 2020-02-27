package com.lizbyu.tree;

import com.lizbyu.lang.Node;
import com.lizbyu.lang.NodeHandler;

public class TreeNodeHandler<V, N extends Node<V>> implements NodeHandler<N> {
    private StringBuffer sb;

    public TreeNodeHandler() {
        sb = new StringBuffer();
    }

    @Override
    public void handle(N node) {
        sb.append(node.getVal());
        System.out.print(node.getVal() + " - ");
    }

    public String signedTag() {
        return sb.toString();
    }

    public void reset() {
        sb = new StringBuffer();
    }
}
