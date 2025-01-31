package dev.algorithms.udemy.dsa.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public static class Node {
        int value;

        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedList() {
        this.length = 0;
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);

        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void reverse() {
        var temp = this.head;
        this.head = this.tail;
        this.tail = temp;

        var after = temp.next;
        Node before = null;

        for (int i = 0; i < this.length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (this.length == 0) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }

        this.tail = newNode;
        this.length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }

        this.length++;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > this.length) {
            return false;
        }

        if (index == 0) {
            this.prepend(value);
            return true;
        }

        if (index == this.length) {
            append(value);
            return true;
        }

        var newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;

        this.length++;

        return true;
    }

    public Node remove(int index) {
        if (index == 0) {
            return this.removeFirst();
        }

        if (index == this.length) {
            return this.removeLast();
        }

        var previous = this.get(index - 1);
        var temp = previous.next;

        previous.next = temp.next;
        temp.next = null;
        this.length--;

        return temp;
    }

    public boolean set(final int index, final int value) {
        var temp = this.get(index);

        if (temp != null) {
            temp.value = value;
            return true;
        }

        return false;
    }

    public Node get(final int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }

        var temp = this.head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public Node removeFirst() {
        if (this.length == 0) {
            return null;
        }

        Node first = this.head;
        this.head = this.head.next;
        first.next = null;

        this.length--;
        if (this.length == 0) {
            this.tail = null;
        }

        return first;
    }

    public Node removeLast() {
        if (this.length == 0) {
            return null;
        }

        Node temp = this.head;
        Node last = this.head;

        while (last.next != null) {
            temp = last;
            last = last.next;
        }

        this.tail = temp;
        this.tail.next = null;

        this.length--;
        if (this.length == 0) {
            this.head = null;
            this.tail = null;
        }

        return last;
    }

    public int getHeadValue() {
        return this.head.value;
    }

    public int getTailValue() {
        return this.tail.value;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public int getLength() {
        return this.length;
    }
}
