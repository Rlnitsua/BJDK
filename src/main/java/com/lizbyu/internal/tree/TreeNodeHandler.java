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
        if (sb.length() <= 1) {
            throw new RuntimeException("signedTag must be handled first!");
        }
        return sb.substring(0, sb.length() - 2);
    }

    void reset() {
        sb = new StringBuffer();
    }
}
