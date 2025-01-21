/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Scanner;

/**
 *
 * @author SUPPER LOQ
 */
public class Inputter {

    private static Scanner ndl;

    public Inputter() {
        ndl = new Scanner(System.in);
    }

    public String getString(String mess) {
        System.out.print(mess);
        return ndl.nextLine().trim();
    }

    public int getInt(String mess) {
        int rs = 0;
        boolean isValid = false;
        do {
            try {
                String temp = getString(mess);
                if (Acceptable.isValid(temp, Acceptable.INTEGER_VALID)) {
                    rs = Integer.parseInt(temp);
                    isValid = true;
                } else {
                    System.out.println("Invalid input! Please enter a valid integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        } while (!isValid);
        return rs;
    }

    public double getDouble(String mess) {
        double rs = 0;
        boolean isValid = false;
        do {
            try {
                String temp = getString(mess);
                if (Acceptable.isValid(temp, Acceptable.DOUBLE_VALID)) {
                    rs = Double.parseDouble(temp);
                    isValid = true;
                } else {
                    System.out.println("Invalid input! Please enter a valid integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        } while (!isValid);
        return rs;
    }

    // hàm nhập dữ liệu và yêu cầu nhập lại dữ liệu nếu dữ liệu không đúng
    public String inputAndLoop(String mess, String pattern) {
        String rs = "";
        boolean more = true;
        do {
            rs = getString(mess);
            more = !Acceptable.isValid(rs, pattern);
            if (more) {
                System.out.println("Data is invalid!. Re-Enter...");
            }
        } while (more);
        return rs.trim();
    }

    // vong lap int
    public int inputAndLoopInt(String mess, String pattern) {
        int rs;
        boolean more = true;
        do {
            rs = getInt(mess);
            more = !Acceptable.isValid(String.valueOf(rs), pattern);
            if (more) {
                System.out.println("Data is invalid!. Re-enter...");
            }
        } while (more);
        return rs;
    }
}
