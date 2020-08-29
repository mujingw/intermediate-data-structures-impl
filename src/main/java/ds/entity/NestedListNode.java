package ds.entity;

public class NestedListNode<T> extends ListNode<T> {

    /**
     * The child node of the current node.
     */
    private NestedListNode<T> child;

    /**
     * @param value the value that the new node holds
     * @param child the child node of the new node
     * @param prev  the node in front of the new node
     * @param next  the node behind the new node
     */
    public NestedListNode(final T value, final NestedListNode<T> child,
                          final NestedListNode<T> prev,
                          final NestedListNode<T> next) {
        super(value);
        super.setNext(next);
        super.setPrev(prev);

        this.child = child;
    }

    /**
     * @return the child node of the current node
     */
    public NestedListNode<T> getChild() {
        return this.child;
    }

    /**
     * @param child new child node to set to
     */
    public void setChild(final NestedListNode<T> child) {
        this.child = child;
    }

    /**
     * @return the NestedListNode immediately behind the current node
     */
    @Override
    public NestedListNode<T> getNext() {
        return (NestedListNode<T>) super.getNext();
    }

    /**
     * @return the NestedListNode immediately before the current node
     */
    @Override
    public NestedListNode<T> getPrev() {
        return (NestedListNode<T>) super.getPrev();
    }
}
