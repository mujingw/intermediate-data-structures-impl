package ds;

import ds.entity.ListNode;
import ds.entity.NestedListNode;
import ds.impl.DoublyLinkedListImpl;
import ds.impl.NestedListImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NestedListImplTest {

    @Test
    public void flattenTest() {
        NestedList<Integer> list =
                new NestedListImpl<>(createNestedListForTests());
        List<Integer> expectedValues =
                new ArrayList<>(Arrays.asList(0, 1, 2, 5, 6, 7, 8, 9, 3, 4));
        NestedListNode<Integer> curr = list.getHead();
        int count = 0;

        NestedListNode<Integer> head = list.flatten();

        while (curr != null) {
            Assert.assertNull(curr.getChild());
            Assert.assertEquals(expectedValues.get(count), curr.getValue());

            count++;
            curr = curr.getNext();
        }

        Assert.assertEquals(count, 10);
        Assert.assertEquals(head, list.getHead());
        Assert.assertEquals(Integer.valueOf(1), head.getNext().getValue());
        Assert.assertEquals(Integer.valueOf(2), head.getNext().getNext().getValue());
        Assert.assertNull(head.getChild());
        Assert.assertNull(head.getNext().getChild());
        Assert.assertNull(head.getNext().getNext().getChild());
        Assert.assertEquals(Integer.valueOf(4), list.getTail().getValue());
    }

    @Test
    public void toStringTest() {
        NestedList<Integer> list =
                new NestedListImpl<>(createNestedListForTests());

        Assert.assertEquals(
                "{NestedList [0, 1, 2, [5, 6, [7, [8, 9, null], null], null], 3, 4, null]}",
                list.toString(false));
        Assert.assertEquals(
                "{NestedList [4, 3, 2, [5, 6, [7, [8, 9, null], null], null], 1, 0, null]}",
                list.toString(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorWithIllegalArgumentTest1() {
        NestedList<Integer> list
                = new NestedListImpl<>(null);

        Assert.assertNotNull(list);
    }

    private NestedListNode<Integer> createNestedListForTests() {
        int numNodes = 10;
        List<ListNode<Integer>> nodes = new ArrayList<>();

        for (int i = 0; i < numNodes; i++) {
            nodes.add(new NestedListNode<>(i, null, null, null));
        }

        NestedListNode<Integer> head = (NestedListNode<Integer>)
                new DoublyLinkedListImpl<>(nodes.subList(0, 5)).getHead();
        NestedListNode<Integer> curr = head;

        /*
            0 <-> 1 <-> 2 <-> 3 <-> 4 <-> null
                        |
                        5 <-> 6 <-> null
                              |
                              7 <-> null
                              |
                              8 <-> 9 <-> null
         */
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                curr.setChild((NestedListNode<Integer>) nodes.get(5));
                curr.getChild().setNext(nodes.get(6));

                NestedListNode<Integer> node6 = curr.getChild().getNext();
                node6.setChild((NestedListNode<Integer>) nodes.get(7));
                node6.getChild().setChild((NestedListNode<Integer>) nodes.get(8));
                node6.getChild().getChild().setNext(nodes.get(9));
            }

            curr = curr.getNext();
        }

        return head;
    }
}
