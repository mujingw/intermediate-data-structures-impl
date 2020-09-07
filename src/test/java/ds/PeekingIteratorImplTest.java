package ds;

import ds.entity.BinaryTreeNode;
import ds.impl.BinarySearchTreeIteratorImpl;
import ds.impl.PeekingIteratorImpl;
import ds.util.BinaryTreeSerializerImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PeekingIteratorImplTest {

    private BinaryTreeSerializerImpl<Integer> serializer;
    private BinarySearchTreeIteratorImpl<Integer> iterator;
    private PeekingIteratorImpl<Integer> peekingIterator;
    private BinaryTreeNode<Integer> root;

    @Before
    public void setUp() {
        serializer = new BinaryTreeSerializerImpl<>(Integer::valueOf);
        root = serializer.deserialize("2,1,X,X,3,X,X");
        iterator = new BinarySearchTreeIteratorImpl<>(root);
        peekingIterator = new PeekingIteratorImpl<>(iterator);
    }

    @Test
    public void peekTest() {
        Assert.assertEquals(Integer.valueOf(1), peekingIterator.next());
        Assert.assertEquals(Integer.valueOf(2), peekingIterator.peek());
        Assert.assertEquals(Integer.valueOf(2), peekingIterator.next());
        Assert.assertEquals(Integer.valueOf(3), peekingIterator.next());
        Assert.assertFalse(peekingIterator.hasNext());
    }

    @Test
    public void hasNextTest() {
        root = serializer.deserialize("7,3,X,X,15,9,X,X,20,X,X");
        iterator = new BinarySearchTreeIteratorImpl<>(root);
        peekingIterator = new PeekingIteratorImpl<>(iterator);

        Assert.assertEquals(Integer.valueOf(3), peekingIterator.next());
        Assert.assertEquals(Integer.valueOf(7), peekingIterator.next());
        Assert.assertTrue(peekingIterator.hasNext());
        Assert.assertEquals(Integer.valueOf(9), peekingIterator.peek());
        Assert.assertEquals(Integer.valueOf(9), peekingIterator.peek());
        Assert.assertTrue(peekingIterator.hasNext());
        Assert.assertEquals(Integer.valueOf(9), peekingIterator.peek());
        Assert.assertEquals(Integer.valueOf(9), peekingIterator.peek());
        Assert.assertEquals(Integer.valueOf(9), peekingIterator.peek());
        Assert.assertEquals(Integer.valueOf(9), peekingIterator.next());
        Assert.assertTrue(peekingIterator.hasNext());
        Assert.assertEquals(Integer.valueOf(15), peekingIterator.next());
        Assert.assertTrue(peekingIterator.hasNext());
        Assert.assertEquals(Integer.valueOf(20), peekingIterator.next());
        Assert.assertFalse(peekingIterator.hasNext());
    }
}
