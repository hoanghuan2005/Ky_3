/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_linkedstack;

/**
 *
 * @author SUPPER LOQ
 */
public class Test {
    public static void decToBin(int k) {
        LinkedStack s = new LinkedStack();
        System.out.print(k + " in binary system is: ");
        while (k > 0) {
            s.push(new Integer(k % 2));
            k = k / 2;
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        decToBin(11);
        System.out.println();
        LinkedStack stack = new LinkedStack();
        stack.push(new Student("01", "Nguyen Xuan Son", 10));
        stack.push(new Student("02", "Supachok", 9.5));
        
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
