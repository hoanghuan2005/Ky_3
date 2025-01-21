/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_211_insertsort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author SUPPER LOQ
 */
public class Lab_211_InsertSort {

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

    // ham insertSort
    private static int[] insertSortArray(int a[]) {
        System.out.println("Unsorted array: " + Arrays.toString(a));

        // Sắp xếp bằng Insertion Sort
        for (int i = 1; i < a.length; i++) {
            int key = a[i]; // Lấy phần tử hiện tại
            int j = i - 1;

            // Dịch chuyển các phần tử lớn hơn key sang phải
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }

            // Chèn key vào đúng vị trí
            a[j + 1] = key;

            // Hiển thị mảng sau mỗi bước sắp xếp
            System.out.println("Step " + i + ": " + Arrays.toString(a));
        }
        return a;
    }

    private static void print(int a[]) {
        System.out.println("Sorted array: " + Arrays.toString(a));
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int n = inputSizeOfArray();
        int a[] = randomValueOfArray(n);
        insertSortArray(a);
        print(a);
    }

}
