/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_stack;

/**
 *
 * @author SUPPER LOQ
 */
public class Test {
    public static void main(String[] args){
        ArrayStack stack = new ArrayStack();
        stack.push(new Student("01", "Nguyen Xuan Son", 10));
        stack.push(new Student("02", "Supachok", 9.5));
        
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
