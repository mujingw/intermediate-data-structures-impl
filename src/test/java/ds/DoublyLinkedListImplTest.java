package ds;

import ds.entity.ListNode;
import ds.impl.DoublyLinkedListImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedListImplTest {

    @Test
    public void constructDoublyLinkedListFromListOfListNodesTest() {
        DoublyLinkedListImpl<Integer> list =
                new DoublyLinkedListImpl<>(createListOfListNodesForTests());

        Assert.assertEquals(10, list.getSize());
        Assert.assertEquals(list.getHead().getValue(), Integer.valueOf(0));
        Assert.assertEquals(list.getTail().getValue(), Integer.valueOf(9));
    }

    @Test
    public void constructDoublyLinkedListFromExistingListTest() {
        DoublyLinkedListImpl<Integer> sourceList
                = new DoublyLinkedListImpl<>(createListOfListNodesForTests());

        DoublyLinkedListImpl<Integer> destList
                = new DoublyLinkedListImpl<>(sourceList.getHead());

        Assert.assertEquals(10, destList.getSize());
        Assert.assertEquals(Integer.valueOf(9), destList.getTail().getValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorWithIllegalArgumentTest() {
        DoublyLinkedListImpl<Integer> list
                = new DoublyLinkedListImpl<>(new ArrayList<>());

        Assert.assertNotNull(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorWithIllegalArgumentTest2() {
        DoublyLinkedListImpl<Integer> list
                = new DoublyLinkedListImpl<>((List<ListNode<Integer>>) null);

        Assert.assertNotNull(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorWithIllegalArgumentTest3() {
        DoublyLinkedListImpl<Integer> list
                = new DoublyLinkedListImpl<>((ListNode<Integer>) null);

        Assert.assertNotNull(list);
    }

    @Test
    public void toStringTest() {
        DoublyLinkedListImpl<Integer> list =
                new DoublyLinkedListImpl<>(createListOfListNodesForTests());

        Assert.assertEquals(
                "{DoublyLinkedList [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, null]}",
                list.toString(false));
        Assert.assertEquals(
                "{DoublyLinkedList [9, 8, 7, 6, 5, 4, 3, 2, 1, 0, null]}",
                list.toString(true));
    }

    private List<ListNode<Integer>> createListOfListNodesForTests() {
        List<ListNode<Integer>> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ListNode<Integer> node = new ListNode<>(i);
            result.add(node);
        }

        return result;
    }
}
