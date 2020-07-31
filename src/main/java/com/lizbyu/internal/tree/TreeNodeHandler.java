package com.lizbyu.internal.tree;

import com.lizbyu.internal.utils.LogUtils;

public class TreeNodeHandler<V, N extends Node<V>> implements NodeHandler<N> {
    private static final String TAG = "TreeNodeHandler";
    private StringBuffer sb;

    public TreeNodeHandler() {
        sb = new StringBuffer();
    }

    @Override
    public void handle(N node) {
        sb.append(node.getVal());
        LogUtils.d(TAG, node.getVal() + " - ");
    }

    String signedTag() {
        if (sb.length() == 0) {
            throw new RuntimeException("signedTag must be handled first!");
        }
        return sb.toString();
    }

    void reset() {
        sb = new StringBuffer();
    }
}
