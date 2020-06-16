package com.lizbyu.internal.tree;

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

    String signedTag() {
        return sb.toString();
    }

    void reset() {
        sb = new StringBuffer();
    }
}
