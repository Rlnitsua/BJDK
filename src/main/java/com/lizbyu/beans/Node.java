package com.lizbyu.beans;

/**
 * basic element in linked data structure
 */
public class Node<V> {
    private V val;

    public Node(V val) {
        this.val = val;
    }

    public V getVal() {
        return val;
    }
}
