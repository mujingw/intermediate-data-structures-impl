package ds;

import ds.entity.BinaryTreeNode;
import ds.impl.BinarySearchTreeIteratorImpl;
import ds.util.BinaryTreeSerializerImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeIteratorImplTest {

    private BinarySearchTreeIteratorImpl<Integer> iterator;
    private BinaryTreeNode<Integer> root;

    @Before
    public void setUp() {
        BinaryTreeSerializerImpl<Integer> serializer = new BinaryTreeSerializerImpl<>(Integer::valueOf);
        root = serializer.deserialize("2,1,X,X,3,X,X");
    }

    @Test
    public void hasNextTest() {
        iterator = new BinarySearchTreeIteratorImpl<>(root);

        Assert.assertTrue(iterator.hasNext());
    }

    @Test
    public void nextTest() {
        iterator = new BinarySearchTreeIteratorImpl<>(root);

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(1), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(2), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(3), iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test (expected = IllegalStateException.class)
    public void nextDoesNotExistTest() {
        iterator = new BinarySearchTreeIteratorImpl<>(root);

        Assert.assertEquals(Integer.valueOf(1), iterator.next());
        Assert.assertEquals(Integer.valueOf(2), iterator.next());
        Assert.assertEquals(Integer.valueOf(3), iterator.next());
        Assert.assertEquals(Integer.valueOf(1), iterator.next());
    }
}
