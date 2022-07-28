package com.revature;

import java.util.Iterator;

public class CustomLinkedList<E> implements CustomList<E> {
    Node<E> head;
    Node<E> tail;


    @Override
    public void add(E e) {
        //implement this method
        //When we add an element to the list, we need to traverse the current list until we get to the end,
        //and then we need to set the next ref on the final node to point to the new final node.
        Node<E> newNode = new Node<>();
        newNode.obj = e;
        if(head == null) {
            head = newNode;
        } else {
            Node<E> cursor = head;
            while(cursor.next != null) {
                cursor = cursor.next;
            }

            cursor.next = newNode;
            newNode.prev = cursor;
        }
        tail = newNode;

    }

    //This one is optional as we removed it from the interface
    public void add(int index, E e) {

        if(index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> newNode = new Node<>();
        newNode.obj = e;
        Node<E> cursor = head;

        for(int i = 0; i < index; i++) {
            if (cursor.next == null) {
                throw new IndexOutOfBoundsException();
            }
            cursor = cursor.next;
        }
        Node<E> temp = cursor.prev;
        newNode.next = cursor;
        newNode.prev = cursor.prev;
        cursor.prev = newNode;
        temp.next = newNode;

    }

    @Override
    public E get(int index) {
        //implement this method
        //you traverse the linked list until you reach the Nth (index) node, and return that.
        Node<E> cursor = head;
        for(int i = 0; i < index; i++)
        {
            cursor = cursor.next;
        }
        return cursor.obj;
    }



    @Override
    public void remove(int index) {
        //implement this method
        //traverse list to the specified index
        //if we are removing the front or back end of the list all we need to do is update the references to not point
        //to the now missing node. If the node is in the middle, you have to "splice" by adjusting the references
        //on either side of the removed node
        Node<E> cursor = head;
        Node<E> prev = null;
        int i = 0;
        while(cursor != null) {
            if(i == index) {
                //we found the node holding the object in question, and now we need to remove.
                //For a singly-linked list: either we are at the head, or we are not.
                if (cursor == head) {
                    //we're still at the head, let's lop it off.
                    head = cursor.next;
                    break;
                } else {
                    //splice out the node
                    prev.next = cursor.next;
                    break;
                }

            }
            prev = cursor;
            cursor = cursor.next;
            i++;
        }
    }

    @Override
    public void remove(E e) {
        //implement this method
        //traverse list looking for a matching object.
        //if we are removing the front or back end of the list all we need to do is update the references to not point
        //to the now missing node. If the node is in the middle, you have to "splice" by adjusting the references
        //on either side of the removed node
        Node<E> cursor = head;
        Node<E> prev = null;
        while(cursor != null) {
            if(cursor.obj.equals(e)) {
                //we found the node holding the object in question, and now we need to remove.
                //For a singly-linked list: either we are at the head, or we are not.
                if (cursor == head) {
                    //we're still at the head, let's lop it off.
                    head = cursor.next;
                    break;
                } else {
                    //splice out the node
                    prev.next = cursor.next;
                    break;
                }

            }
            prev = cursor;
            cursor = cursor.next;
        }

    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> cursor = head;

            @Override
            public boolean hasNext() {
                return (cursor != null);
            }

            @Override
            public E next() {
                //implement this method
                E e = cursor.obj;
                cursor = cursor.next;
                return e;

            }
        };
    }

    private class Node<E> {
        //Node represents a "payload" which is a reference to an object we want the list to store.
        //Nodes also have references to other nodes, and this is how we make the linked list.
        //A linked list is made up of a chain of linked nodes in this way.

        E obj;
        Node<E> next;
        Node<E> prev;


    }

}