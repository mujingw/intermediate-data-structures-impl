package ds.entity;

public class ListNode<T> {

    /**
     * The information that the node stores.
     */
    private T value;

    /**
     * The node whose position is immediately in front of the current node.
     */
    private ListNode<T> prev;

    /**
     * The node whose position is immediately behind the current node.
     */
    private ListNode<T> next;

//    /**
//     * The child node of the current node.
//     */
//    private ListNode<T> child;

    /**
     *
     * @param value the value that the node holds
     */
    public ListNode(final T value) {
        this.value = value;
    }

    /**
     *
     * @return the piece of data which the node holds
     */
    public T getValue() {
        return this.value;
    }

    /**
     *
     * @return the node immediately behind the current node
     */
    public ListNode<T> getNext() {
        return this.next;
    }

    /**
     *
     * @param next the node to be appended to the current node
     */
    public void setNext(final ListNode<T> next) {
        this.next = next;
    }

    /**
     *
     * @return the node that's immediately in front of current node
     */
    public ListNode<T> getPrev() {
        return this.prev;
    }

    /**
     *
     * @param prev the node to be inserted to the front of the current node
     */
    public void setPrev(final ListNode<T> prev) {
        this.prev = prev;
    }
}
