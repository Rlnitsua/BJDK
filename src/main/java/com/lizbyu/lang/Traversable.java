package com.lizbyu.lang;

/**
 * A class implements the <code>Traversable</code> interface
 * to indicate that it is legal for traverse all elements
 */
public interface Traversable {
    /**
     * traverse the ADT in order
     */
    void sequentialTraversal();

    /**
     * traverse the ADT in reverse order
     */
    void reverseTraversal();
}
