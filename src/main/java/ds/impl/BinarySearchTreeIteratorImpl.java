package ds.impl;

import ds.Iterator;
import ds.entity.BinaryTreeNode;

import java.util.Stack;

public class BinarySearchTreeIteratorImpl<T> implements Iterator<T> {

    /**
     * A stack data structure that helps inorder traversal.
     */
    private final Stack<BinaryTreeNode<T>> stack;

    /**
     *
     * @param root root node of the binary search tree to be
     *           iterated through
     */
    public BinarySearchTreeIteratorImpl(final BinaryTreeNode<T> root) {
        this.stack = new Stack<>();
        pushSelfAndAllLeftDescendants(root);
    }

    /**
     *
     * @return whether or not there is a node after the current node
     */
    @Override
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

    /**
     *
     * @return the value in the next node, if there is a node next
     *  to the node the iterator is currently sitting at
     */
    @Override
    public T next() {
        if (hasNext()) {
            BinaryTreeNode<T> nextNode = stack.pop();
            pushSelfAndAllLeftDescendants(nextNode.getRight());

            return nextNode.getValue();
        } else {
            throw new IllegalStateException("Next node does not exist!");
        }
    }

    private void pushSelfAndAllLeftDescendants(final BinaryTreeNode<T> root) {
        BinaryTreeNode<T> curr = root;

        while (curr != null) {
            this.stack.push(curr);
            curr = curr.getLeft();
        }
    }
}
