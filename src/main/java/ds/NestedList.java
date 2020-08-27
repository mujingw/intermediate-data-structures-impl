package ds;

import ds.entity.NestedListNode;

public interface NestedList<T> extends DoublyLinkedList {

    /**
     * Converts the nested linked list into a doubly linked list.
     *
     * @return the head of the converted list
     */
    NestedListNode<T> flatten();

    /**
     * @return the head of the rested linked list
     */
    NestedListNode<T> getHead();
}
