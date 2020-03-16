package com.lizbyu.tree;

/**
 * handle each node, print message and cache node info
 * @param <N> node
 */
public interface NodeHandler<N> {
    void handle(N node);
}
