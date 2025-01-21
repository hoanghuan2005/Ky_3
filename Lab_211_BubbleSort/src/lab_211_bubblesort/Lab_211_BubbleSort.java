/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_211_bubblesort;

/**
 *
 * @author SUPPER LOQ
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lab_211_BubbleSort {

    private static final Scanner sc = new Scanner(System.in);

    //Ham check input is a integer
    private static int checkInputInt(int index) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                if (index >= 0) {
                    System.err.println("Invalid input for a[" + index + "]. Please input a valid number!");
                    System.out.print("Enter again a[" + index + "]: ");
                } else {
                    System.err.println("Invalid input. Please input a valid number!");
                    System.out.print("Enter again: ");
                }
            }
        }
    }

    // Hàm input size of array: allow user input number of array
    private static int inputSizeOfArray() {
        System.out.print("Enter number of array: ");
        int n;
        while (true) {
            n = checkInputInt(-1); // Kiểm tra đầu vào là số nguyên
            if (n > 0) {
                break; // Nếu n > 0, thoát khỏi vòng lặp
            }
            System.out.println("Array size must be greater than 0!");
            System.out.print("Enter again: ");
        }
        return n;
    }

    // Hàm input value of array
    private static int[] inputValueOfArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "]: ");
            a[i] = checkInputInt(i);
        }
        return a;
    }

    // ham random value of array
    private static int[] randomValueOfArray(int n) {
        Random rd = new Random();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(11 - 1) + 1;
        }
        return a;
    }

    // hàm swap 2 number
    private static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // sort array by bubble sort
    private static void sortArrayByBubbleSort(int a[]) {
        System.out.println("Unsorted array:" + Arrays.toString(a));

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
//        System.out.println("Sorted array: " + Arrays.toString(a));
    }

    // hàm display array after sort
    private static void printAfterBubbleSort(int a[]) {
        System.out.println("Sorted array: " + Arrays.toString(a));
    }

    public static void main(String[] args) {
        int n = inputSizeOfArray();
        int a[] = randomValueOfArray(n);
        sortArrayByBubbleSort(a);
        printAfterBubbleSort(a);

        // TODO code application logic here
//        System.out.println("Enter number of array");
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        int a[] = new int[x];
//        Random rd = new Random(x + 1);
//        for (int i = 0; i < x; i++) {
//            a[i] = rd.nextInt(1, 11);
//        }
//        System.out.println(Arrays.toString(a));
    }

}
