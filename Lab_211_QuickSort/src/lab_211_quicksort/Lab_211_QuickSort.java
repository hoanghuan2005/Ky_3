/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_211_quicksort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author SUPPER LOQ
 */
public class Lab_211_QuickSort {

    private static final Scanner sc = new Scanner(System.in);

    // Ham check input
    private static int checkInputInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }

    // nhap size of array
    private static int inputSizeOfArray() {
        System.out.println("Enter number array: ");
        int n;
        while (true) {
            n = checkInputInt();
            if (n > 0) {
                break;
            }
            System.err.println("Please enter n > 0!");
            System.out.print("Enter again: ");
        }
        return n;
    }

    // random value of array
    private static int[] randomValueOfArray(int n) {
        int a[] = new int[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(11 - 1) + 1;
        }
        return a;
    }

    private static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    // hàm quicksort
    private static int[] quickSortArray(int a[]){
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
