package ds;

import ds.entity.BinaryTreeNode;

public interface BinaryTreeSerDes<T> {

    /**
     *
     * @param root the root of the binary to be serialized
     * @return a string representation of the serialized binary tree
     */
    String serialize(BinaryTreeNode<T> root);

    /**
     *
     * @param data a string representation of the binary tree
     *             to be de-serialized
     * @return the root of the de-serialized binary tree
     */
    BinaryTreeNode<T> deserialize(String data);
}
