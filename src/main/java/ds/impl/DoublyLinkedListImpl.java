package ds.impl;

import ds.DoublyLinkedList;
import ds.entity.ListNode;

import java.util.List;

public class DoublyLinkedListImpl<T> implements DoublyLinkedList {

    /**
     * Head (front, first node) of the doubly-linked list.
     */
    private ListNode<T> head;

    /**
     * Tail (end, last node) of the doubly-linked list.
     */
    private ListNode<T> tail;

    /**
     * The number of nodes in the list.
     */
    private int size;

    /**
     * Default constructor of the class.
     */
    public DoublyLinkedListImpl() {
        this.size = 0;
    }

    /**
     * Constructs a new instance of DoublyLinkedListImpl from an existing
     * doubly-linked list's head node.
     *
     * @param head the beginning of the existing list to be constructed
     */
    public DoublyLinkedListImpl(final ListNode<T> head) {
        if (head == null) {
            throw new IllegalArgumentException();
        }

        this.head = head;
        ListNode<T> curr = head;
        ListNode<T> prev = null;

        while (curr != null) {
            this.size++;

            prev = curr;
            curr = curr.getNext();
        }

        this.tail = prev;
    }

    /**
     * @param nodes list of individual nodes to be linked
     */
    public DoublyLinkedListImpl(final List<ListNode<T>> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.size = 0;

        for (ListNode<T> node : nodes) {
            if (this.size == 0) {
                this.head = node;
            } else {
                ListNode<T> last = this.tail;
                node.setNext(null);
                last.setNext(node);
                node.setPrev(last);
            }

            this.tail = node;
            this.size++;
        }
    }

    /**
     *
     * @return the first node (from the front) of the list
     */
    public ListNode<T> getHead() {
        return this.head;
    }

    /**
     *
     * @return the last node (front the front) of the list
     */
    public ListNode<T> getTail() {
        return this.tail;
    }

    /**
     *
     * @return the number of nodes in the list
     */
    public int getSize() {
        return this.size;
    }

    /**
     * @param reverse indicates whether or not to construct the string
     *                in a reversed order (i.e., from tail to head)
     * @return a string representation of the doubly-linked list
     */
    @Override
    public String toString(final boolean reverse) {
        ListNode<T> curr = reverse ? tail : head;
        StringBuilder sb = new StringBuilder("{DoublyLinkedList [");

        while (curr != null) {
            sb.append(curr.getValue()).append(", ");

            if (reverse) {
                curr = curr.getPrev();
            } else {
                curr = curr.getNext();
            }
        }

        sb.append("null]}");

        return sb.toString();
    }
}
