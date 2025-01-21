/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_linkedstack;

import java.util.EmptyStackException;

/**
 *
 * @author SUPPER LOQ
 */
public class LinkedStack implements StackADT {

    private Node head;

    public LinkedStack() {
        head = null;
    }

    @Override
    public void clear() {
        this.head = null;
    }

    @Override
    public boolean isEmpty() {
        return this.head==null;
    }

    @Override
    public void push(Object obj) {
        this.head=new Node(obj, head);
    }

    @Override
    public Object pop() throws EmptyStackException{
        Object obj = head.getInfo();
        head = head.getNext();
        return obj;
    }

    @Override
    public Object top() throws EmptyStackException{
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object obj = head.getInfo();
        return obj;
    }
}
