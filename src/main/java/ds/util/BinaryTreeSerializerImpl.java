package ds.util;

import ds.entity.BinaryTreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Function;

public final class BinaryTreeSerializerImpl<T>
        implements BinaryTreeSerializer<T> {

    /**
     * The character that separates the string representation of each node.
     */
    private static final String DELIMITER = ",";

    /**
     * The string representation of a null node.
     */
    private static final String NULL_NODE = "X";

    /**
     * The method that converts a String type value to a T type value.
     */
    private final Function<String, T> converter;

    /**
     *
     * @param converter a method that converts String type object to type T
     */
    public BinaryTreeSerializerImpl(final Function<String, T> converter) {
        this.converter = converter;
    }

    /**
     *
     * @param root the root of the binary tree to be serialized
     * @return a preorder string representation of the binary tree
     */
    @Override
    public String serialize(final BinaryTreeNode<T> root) {
        StringBuilder sb = new StringBuilder();

        buildString(sb, root);

        return sb.substring(0, sb.length() - 1);
    }

    /**
     *
     * @param data a preorder string representation of the binary tree
     *             to be de-serialized
     * @return the root node of the de-serialized binary tree
     */
    @Override
    public BinaryTreeNode<T> deserialize(final String data) {
        Deque<String> nodes = new LinkedList<>(
                Arrays.asList(data.split(DELIMITER)));

        return buildTree(nodes);
    }

    private void buildString(final StringBuilder sb,
                             final BinaryTreeNode<T> root) {
        if (root == null) {
            sb.append(NULL_NODE).append(DELIMITER);
        } else {
            sb.append(root.getValue()).append(DELIMITER);
            buildString(sb, root.getLeft());
            buildString(sb, root.getRight());
        }
    }

    private BinaryTreeNode<T> buildTree(final Deque<String> nodes) {
        String value = nodes.removeFirst();

        if (value.equals(NULL_NODE)) {
            return null;
        } else {
            BinaryTreeNode<T> root =
                    new BinaryTreeNode<>(converter.apply(value));
            root.setLeft(buildTree(nodes));
            root.setRight(buildTree(nodes));

            return root;
        }
    }
}
