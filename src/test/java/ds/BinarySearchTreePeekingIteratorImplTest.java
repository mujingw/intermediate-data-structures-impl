package ds;

import ds.entity.BinaryTreeNode;
import ds.impl.BinarySearchTreeIteratorImpl;
import ds.impl.BinarySearchTreePeekingIteratorImpl;
import ds.util.BinaryTreeSerializerImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreePeekingIteratorImplTest {

    private BinaryTreeSerializerImpl<Integer> serializer;
    private BinarySearchTreeIteratorImpl<Integer> iterator;
    private BinarySearchTreePeekingIteratorImpl<Integer> peekingIterator;
    private BinaryTreeNode<Integer> root;

    @Before
    public void setUp() {
        serializer = new BinaryTreeSerializerImpl<>(Integer::valueOf);
        root = serializer.deserialize("2,1,X,X,3,X,X");
        iterator = new BinarySearchTreeIteratorImpl<>(root);
        peekingIterator = new BinarySearchTreePeekingIteratorImpl<>(iterator);
    }

    @Test
    public void peekTest() {
        Assert.assertEquals(Integer.valueOf(1), peekingIterator.next());
        Assert.assertEquals(Integer.valueOf(2), peekingIterator.peek());
        Assert.assertEquals(Integer.valueOf(2), peekingIterator.next());
        Assert.assertEquals(Integer.valueOf(3), peekingIterator.next());
        Assert.assertFalse(peekingIterator.hasNext());
    }
}
