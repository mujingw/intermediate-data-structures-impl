package ds.entity;

public class BinaryTreeNode<T> {
    /**
     * Information carried by the node.
     */
    private final T value;

    /**
     * Left child of the binary tree node.
     */
    private BinaryTreeNode<T> left;

    /**
     * Right child of the binary tree node.
     */
    private BinaryTreeNode<T> right;

    /**
     *
     * @param value the piece of data the node holds
     */
    public BinaryTreeNode(final T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     *
     * @return the piece of data the current node holds
     */
    public T getValue() {
        return this.value;
    }

    /**
     *
     * @return the left child of the binary tree node
     */
    public BinaryTreeNode<T> getLeft() {
        return this.left;
    }

    /**
     *
     * @return the right child of the binary tree node
     */
    public BinaryTreeNode<T> getRight() {
        return this.right;
    }

    /**
     *
     * @param left the node to which the current node's left child points
     */
    public void setLeft(final BinaryTreeNode<T> left) {
        this.left = left;
    }

    /**
     *
     * @param right the node to which the current node's right child points
     */
    public void setRight(final BinaryTreeNode<T> right) {
        this.right = right;
    }
}
