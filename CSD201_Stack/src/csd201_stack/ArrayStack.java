/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_stack;

import java.util.EmptyStackException;

/**
 *
 * @author SUPPER LOQ
 */
public class ArrayStack implements StackADT{
    private Object[] array;
    private int top, max;

    public ArrayStack() {
        this(50);
    }

    public ArrayStack(int max) {
        this.max = max;
        array = new Object[max];
        top = -1;
    }

    private boolean grow(){
        this.max = this.max+this.max/2;
        Object[] temp = new Object[this.max];
        for (int i = 0; i < top; i++) {
            temp[i] = array[i];
        }
        array =temp;
        return true;
    }
    @Override
    public void clear() {
        this.array = new Object[max];
    }

    @Override
    public boolean isEmpty() {
        return top==-1;
    }

    @Override
    public void push(Object obj) {
        if (isFull()) {
            if (!grow()) {
                return;
            }
        }
        this.array[++top] = obj;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object obj = this.array[top--];
        return obj;
    }

    @Override
    public Object top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return this.array[top];
    }

    @Override
    public boolean isFull() {
        return top ==max-1;
    }
     
}
