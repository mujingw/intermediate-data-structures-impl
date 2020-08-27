package ds.impl;

import ds.NestedList;
import ds.entity.NestedListNode;

import java.util.Stack;

public class NestedListImpl<T> extends DoublyLinkedListImpl<T>
        implements NestedList<T> {

    /**
     * Head of the nested linked list.
     */
    private final NestedListNode<T> head;

    /**
     * @param head the beginning of an externally constructed nested list
     */
    public NestedListImpl(final NestedListNode<T> head) {
        this.head = head;
    }

    /**
     * @return head of the flattened list
     */
    @Override
    public NestedListNode<T> flatten() {
        if (this.head == null) {
            return null;
        }

        Stack<NestedListNode<T>> stack = new Stack<>();
        stack.push(this.head);
        NestedListNode<T> dummy =
                new NestedListNode<>(null, null, null, this.head);
        NestedListNode<T> prev = dummy;

        while (!stack.isEmpty()) {
            NestedListNode<T> curr = stack.pop();
            curr.setPrev(prev);
            prev.setNext(curr);

            if (curr.getNext() != null) {
                stack.push(curr.getNext());
                curr.setNext(null);
            }

            if (curr.getChild() != null) {
                stack.push(curr.getChild());
                curr.setChild(null);
            }

            prev = curr;
        }

        dummy.getNext().setPrev(null);

        return dummy.getNext();
    }

    /**
     * @return the first node of the nested list object
     */
    @Override
    public NestedListNode<T> getHead() {
        return this.head;
    }

    /**
     * @param reverse indicates whether or not to construct the string
     *                in a reversed order (i.e., from tail to head)
     * @return a string representation of the nested doubly-linked list
     */
    @Override
    public String toString(final boolean reverse) {
        StringBuilder sb = new StringBuilder("{NestedList ");

        if (!reverse) {
            Stack<NestedListNode<T>> stack = new Stack<>();
            toStringHelper(stack, this.head, sb);
        }

        sb.setLength(sb.length() - 2);
        sb.append("}");

        return sb.toString();
    }

    private void toStringHelper(final Stack<NestedListNode<T>> stack,
                                final NestedListNode<T> levelHead,
                                final StringBuilder sb) {
        NestedListNode<T> curr = levelHead;
        sb.append("[");

        while (curr != null) {
            sb.append(curr.getValue()).append(", ");

            if (curr.getChild() != null) {
                stack.push(curr);
            }

            curr = curr.getNext();

            if (!stack.isEmpty()) {
                toStringHelper(stack, stack.pop().getChild(), sb);
            }
        }

        sb.append("null], ");
    }
}
