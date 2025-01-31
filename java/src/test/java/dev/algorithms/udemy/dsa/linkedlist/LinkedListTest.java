package dev.algorithms.udemy.dsa.linkedlist;

import dev.algorithms.udemy.dsa.linkedlist.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LinkedListTest {
    @Test
    public void givenNonEmptyLinkedList_whenPrependNewNode_thenLengthIncreasesAndHeadEqualsNewNode() {
        final int expectedValue = 12;
        final int expectedLength = 3;

        final LinkedList linkedList = new LinkedList(10);

        linkedList.prepend(11);
        linkedList.prepend(expectedValue);

        assertEquals(expectedValue, linkedList.getHeadValue());
        assertEquals(expectedLength, linkedList.getLength());
    }

    @Test
    public void givenEmptyLinkedList_whenPrependNewNode_thenLengthEqualsOneAndHeadAndTailEqualsNewNode() {
        final int expectedValue = 10;
        final int expectedLength = 1;

        final LinkedList linkedList = new LinkedList();

        linkedList.prepend(expectedValue);

        assertEquals(expectedValue, linkedList.getHeadValue());
        assertEquals(expectedValue, linkedList.getTailValue());
        assertEquals(expectedLength, linkedList.getLength());
    }

    @Test
    public void givenNonEmptyLinkedList_whenAppendNewNode_thenLengthIncreasesAndTailEqualsNewNode() {
        final int expectedValue = 12;
        final int expectedLength = 3;

        final LinkedList linkedList = new LinkedList(10);

        linkedList.append(11);
        linkedList.append(expectedValue);

        assertEquals(expectedValue, linkedList.getTailValue());
        assertEquals(expectedLength, linkedList.getLength());
    }

    @Test
    public void givenEmptyLinkedList_whenAppendNewNode_thenLengthEqualsOneAndHeadAndTailEqualsNewNode() {
        var expectedValue = 10;
        var expectedLength = 1;
        var linkedList = new LinkedList();

        linkedList.append(expectedValue);

        assertEquals(expectedValue, linkedList.getHeadValue());
        assertEquals(expectedValue, linkedList.getTailValue());
        assertEquals(expectedLength, linkedList.getLength());
    }

    @Test
    public void givenEmptyLinkedList_whenRemoveFirst_thenLengthEqualsZeroAndHeadAndTailEqualsNullAndReturnNull() {
        var expectedLength = 0;
        var linkedList = new LinkedList();
        var node = linkedList.removeFirst();

        assertNull(linkedList.getHead());
        assertNull(linkedList.getTail());
        assertEquals(expectedLength, linkedList.getLength());

        assertNull(node);
    }

    @Test
    public void givenLinkedListWithOneNode_whenRemoveFirst_thenLengthEqualsZeroAndHeadAndTailEqualsNullAndReturnNode() {
        var expectedValue = 10;
        var expectedLength = 0;
        var linkedList = new LinkedList(expectedValue);
        var node = linkedList.removeFirst();

        assertNull(linkedList.getHead());
        assertNull(linkedList.getTail());
        assertEquals(expectedLength, linkedList.getLength());

        assertNotNull(node);
        assertEquals(expectedValue, node.value);
    }

    @Test
    public void givenLinkedListWithTwoNodes_whenRemoveFirst_thenLengthEqualsOneAndHeadAndTailEqualsLastNodeAndReturnFirstNode() {
        var expectedValue = 10;
        var expectedLastNodeValue = 11;
        var expectedLength = 1;
        var linkedList = new LinkedList(expectedValue);

        linkedList.append(expectedLastNodeValue);

        var node = linkedList.removeFirst();

        assertEquals(expectedLastNodeValue, linkedList.getHeadValue());
        assertEquals(expectedLastNodeValue, linkedList.getTailValue());
        assertEquals(expectedLength, linkedList.getLength());

        assertNotNull(node);
        assertEquals(expectedValue, node.value);
    }

    @Test
    public void givenEmptyLinkedList_whenRemoveLast_thenLengthEqualsZeroAndHeadAndTailEqualsNullAndReturnNull() {
        var expectedLength = 0;
        var linkedList = new LinkedList();
        var node = linkedList.removeLast();

        assertNull(linkedList.getHead());
        assertNull(linkedList.getTail());
        assertEquals(expectedLength, linkedList.getLength());

        assertNull(node);
    }

    @Test
    public void givenLinkedListWithOneNode_whenRemoveLast_thenLengthEqualsZeroAndHeadAndTailEqualsNullAndReturnNode() {
        final int expectedValue = 10;
        final int expectedLength = 0;
        final LinkedList linkedList = new LinkedList(expectedValue);

        var node = linkedList.removeLast();

        assertNull(linkedList.getHead());
        assertNull(linkedList.getTail());
        assertEquals(expectedLength, linkedList.getLength());

        assertNotNull(node);
        assertEquals(expectedValue, node.value);
    }

    @Test
    public void givenLinkedListWithTwoNodes_whenRemoveLast_thenLengthEqualsOneAndHeadAndTailEqualsFirstNodeAndReturnLastNode() {
        final int expectedFirstNodeValue = 10;
        final int expectedValue = 11;
        final int expectedLength = 1;

        final LinkedList linkedList = new LinkedList(expectedFirstNodeValue);
        linkedList.append(expectedValue);

        var node = linkedList.removeLast();

        assertEquals(expectedFirstNodeValue, linkedList.getHeadValue());
        assertEquals(expectedFirstNodeValue, linkedList.getTailValue());
        assertEquals(expectedLength, linkedList.getLength());

        assertNotNull(node);
        assertEquals(expectedValue, node.value);
    }
}
