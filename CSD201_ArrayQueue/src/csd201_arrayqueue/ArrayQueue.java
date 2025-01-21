/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_arrayqueue;

/**
 *
 * @author SUPPER LOQ
 */
public class ArrayQueue implements QueueADT {

    private Object[] a;
    private int max;
    private int first, last;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int max) {
        this.max = max;
        a = new Object[max];
        first = last = -1;
    }

    @Override
    public void clear() {
        a = new Object[max];
        first = last = -1;
    }

    @Override
    public boolean isEmpty() {
        return (first == -1 && last == -1);
    }

    public boolean isFull() {
        return ((first == 0 && last == max - 1) || (first == last + 1));
    }

    public boolean grow() {
        int new_max = max * 2;
        return false;
    }

    @Override
    public void enqueue(Object obj) {
        if (isFull()) {
            if (!grow()) {
                return;
            }
        }
        if (true) {
            
        }
    }

    @Override
    public Object dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        Object obj = a[first];
        if (first==last) {
            first=last=-1;
        }else if (first==max-1) {
            first=0;
        } else {
            first++;
        }
        return obj;
    }

    @Override
    public Object front() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return a[first];
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
