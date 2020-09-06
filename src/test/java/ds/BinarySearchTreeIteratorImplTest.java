package ds;

import ds.entity.BinaryTreeNode;
import ds.impl.BinarySearchTreeIteratorImpl;
import ds.util.BinaryTreeSerializerImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeIteratorImplTest {

    private BinaryTreeSerializerImpl<Integer> serializer;
    private BinarySearchTreeIteratorImpl<Integer> iterator;
    private BinaryTreeNode<Integer> root;

    @Before
    public void setUp() {
        serializer = new BinaryTreeSerializerImpl<>(Integer::valueOf);
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

    @Test
    public void nextTest2() {
        root = serializer.deserialize("7,3,X,X,15,9,X,X,20,X,X");
        iterator = new BinarySearchTreeIteratorImpl<>(root);

        Assert.assertEquals(Integer.valueOf(3), iterator.next());
        Assert.assertEquals(Integer.valueOf(7), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(9), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(15), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(20), iterator.next());
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
