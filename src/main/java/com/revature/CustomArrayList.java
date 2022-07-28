package com.revature;

import java.util.Iterator;

public class CustomArrayList<E> implements CustomList<E> {
    float growFactor = 1.5f;
    int size = 4;
    int currentSize = 0;
    final int maxSize = 100000;
    Object[] array = new Object[size];


    @Override
    public void add(E e) {
        if(currentSize >= size) {
            growArray();
        }
        array[currentSize] = e;
        currentSize++;
    }

    public void add(int index, E e) {
        for(int i = index + 1; i < array.length; i++) {
            array[i] = array[i-1];
        }
    }

    @Override
    public E get(int index) {
        return (E)array[index];
    }

    @Override
    public void remove(int index) {
        array[index] = null;
        //need to shift everything after the index to the left
        for(int i = index; i < array.length; i++) {
            array[i] = array[i+1];
            array[i+1] = null;
        }

        currentSize--;
    }

    @Override
    public void remove(E e) {
        boolean complete = false;
        for(int i = 0; i < array.length; i++) {
            if(complete) {
                //we've already removed the element, now we need to shift.
                array[i-1] = array[i];
                array[i] = null;
            } else if (array[i].equals(e)) {
                complete = true;
                remove(i);
            }

        }
        currentSize--;
    }

    @Override
    public void clear() {
        size = 4;
        currentSize = 0;
        array = new Object[size];
    }


    private void growArray() {

        size = (int)(size * growFactor);
        Object[] temp = new Object[size];
        for(int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    private void resizeArray(int index) {
        if(index >= size && index <= maxSize) {
            size = index + 1;

        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;


            @Override
            public boolean hasNext() {
                if(array[index] != null || index > size) {
                    return true;
                }
                return false;
            }

            @Override public E next() {
                E temp = (E)array[index];
                index++;
                return temp;
            }
        };
    }
}
