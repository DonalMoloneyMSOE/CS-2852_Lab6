/*
 *CS 2852 - 011
 *Fall 2017
 *Lab 6 - Recursion
 *Name: Donal Moloney
 *Created: 10/12/2017
 */
package Moloneyda;

import java.util.AbstractList;

/**
 * A recursive implementation of a linked list. (to be implemented...)
 */
public class LinkedList<E> extends AbstractList<E> {
    /**
     * Node for singly-linked list
     */
    private class Node {
        E datum;
        Node next;

        /**
         * Construct a node with the specified datum and next
         */
        Node(E datum, Node next) {
            this.datum = datum;
            this.next = next;
        }
    }

    private Node head = null;

    /**
     * Return the number of elements in the list
     *
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return size(head);
    }


    /**
     * Gets the index-th element of the list
     *
     * @param index the position of the element to get
     * @return the element at that index
     */
    @Override
    public E get(int index) {
        if (index >= size() || 0 > index) {
            throw new IndexOutOfBoundsException("Out of Range");
        } else {
            return get(index, head);
        }
    }

    /**
     * Changes the index-th element of the list to the
     * specified value.
     *
     * @param index    the position of the element to change
     * @param newValue the new value to change it to
     * @return the old value of that element.
     */
    @Override
    public E set(int index, E newValue) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException(
                    "The element you are trying to access does not exist");
        } else {
            return set(index, newValue, head);
        }
    }

    /**
     * Add a value as the new element at a position specified by the index
     *
     * @param index    the position of the newly-added element
     * @param newValue the value of the newly added element
     */
    @Override
    public void add(int index, E newValue) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("Out of range");
        } else {
            add(index, newValue, head);
        }
    }

    /**
     * Remove the element at a position indicated by the index
     *
     * @param index the position of the element to remove
     * @return the value of the removed element
     */
    @Override
    public E remove(int index) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("Out of range");
        } else {
            return remove(index, head);
        }
    }

    /**
     * Private recursion helper method for size()
     *
     * @param n the head of the linked list
     * @return the number of elements in the list
     */
    private int size(Node n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + size(n.next);
        }
    }

    /**
     * Private recursion helper method for get()
     *
     * @param index
     * @param n     the head of the linked list
     * @return The element at teh specified index
     */
    private E get(int index, Node n) {
        if (index == 0) {
            E returnNode = n.datum;
            return returnNode;
        } else {
            return get(index - 1, n.next);
        }
    }

    /**
     * Private recursion helper method for set()
     *
     * @param index    the index that you are setting a new value too
     * @param newValue the new value being set to the index
     * @param n        the head of the linked list
     * @return the old value that has been over written
     */
    private E set(int index, E newValue, Node n) {
        if (n == null) {
            throw new IndexOutOfBoundsException("Your list is empty");
        } else if (index == 0) {
            E temp = n.datum;
            n.datum = newValue;
            return temp;
        } else {
            index = index - 1;
            return set(index--, newValue, n.next);
        }
    }


    /**
     * The private helper method for the add()
     *
     * @param index    the index that you are setting a new value too
     * @param newValue the new value being set to the index
     * @param head     the head of the linked list
     */
    private void add(int index, E newValue, Node head) {
        if (head == null) {
            Node newNode = new Node(newValue, head);
            this.head = newNode;
        } else if (index == 1) {
            Node newNode = new Node(newValue, head.next);
            head.next = newNode;
        } else if (index == 0) {
            Node newNode = new Node(newValue, head);
            this.head = newNode;
        } else {
            index--;
            add(index, newValue, head.next);
        }
    }


    /**
     * The private helper method for the remove()
     *
     * @param index the index that you are setting a new value too
     * @param head  the head of the linked list
     * @return the element removed from the list
     */
    private E remove(int index, Node head) {
        if (head == null) {
            throw new IndexOutOfBoundsException(
                    "The index your are trying to remove does not " + "exist");
        } else if (index == 1) {
            E temp = head.next.datum;
            head.next = head.next.next;
            return temp;
        } else if (index == 0) {
            E temp = head.datum;
            this.head = head.next;
            return temp;
        } else {
            index = index - 1;
            return remove(index, head.next);
        }
    }
}
