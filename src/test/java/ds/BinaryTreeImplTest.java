package ds;

import ds.entity.BinaryTreeNode;
import ds.impl.BinaryTreeImpl;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeImplTest {

    @Test
    public void serializeTest() {
        BinaryTreeSerDes<Integer> serializer =
                new BinaryTreeImpl<>(Integer::valueOf);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(5);
        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node3);
        node2.setRight(node4);

        String result = serializer.serialize(root);

        Assert.assertEquals("1,2,X,X,3,4,X,X,5,X,X", result);
    }

    @Test
    public void deserializeTest() {
        String data = "1,2,X,X,3,4,X,X,5,X,X";
        BinaryTreeSerDes<Integer> deserializer =
                new BinaryTreeImpl<>(Integer::valueOf);

        BinaryTreeNode<Integer> root = deserializer.deserialize(data);

        Assert.assertEquals(Integer.valueOf(1), root.getValue());
        Assert.assertEquals(Integer.valueOf(2), root.getLeft().getValue());
        Assert.assertEquals(Integer.valueOf(3), root.getRight().getValue());
        Assert.assertEquals(Integer.valueOf(4), root.getRight().getLeft().getValue());
        Assert.assertEquals(Integer.valueOf(5), root.getRight().getRight().getValue());
    }
}
