package ds;

import ds.entity.ListNode;
import ds.impl.DoublyLinkedListImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedListImplTest {

    @Test
    public void constructDoublyLinkedListTest() {
        DoublyLinkedListImpl<Integer> list =
                new DoublyLinkedListImpl<>(createDoublyLinkedListForTests());

        Assert.assertEquals(
                "{DoublyLinkedList [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, null]}",
                list.toString(false));
        Assert.assertEquals(10, list.getSize());
        Assert.assertEquals(list.getHead().getValue(), Integer.valueOf(0));
        Assert.assertEquals(list.getTail().getValue(), Integer.valueOf(9));
    }

    private List<ListNode<Integer>> createDoublyLinkedListForTests() {
        List<ListNode<Integer>> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ListNode<Integer> node = new ListNode<>(i);
            result.add(node);
        }

        return result;
    }
}
