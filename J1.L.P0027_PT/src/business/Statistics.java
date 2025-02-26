/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.StatisticalInfo;
import model.Student;

/**
 *
 * @author SUPPER LOQ
 */
public class Statistics extends HashMap<String, StatisticalInfo> {

    public static final String HEADER_TABLE
            = "-------------------------------------------------------------\n"
            + "| Peak Name        | Number of Participants  | Total Cost   |\n"
            + "-------------------------------------------------------------";
    public static final String FOOTER_TABLE
            = "-------------------------------------------------------------\n";

    public Statistics() {
        super();
    }

    public Statistics(List<Student> list) {
        super();
        statisticalize(list);
    }

    public final void statisticalize(List<Student> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("No data to process.");
            return;
        }
        for (Student i : list) {
            String mountainCode = i.getMountainCode();
            double tuitionFee = i.getTutionFee();
            if (this.containsKey(mountainCode)) {
                StatisticalInfo x = this.get(mountainCode);
                x.setNumOfStudent(x.getNumOfStudent() + 1);
                x.setTotalCost(x.getTotalCost() + tuitionFee);
            } else {
                StatisticalInfo z = new StatisticalInfo(mountainCode, 1, tuitionFee);
                this.put(mountainCode, z);
            }
        }
        show();
    }

    public void show() {
        System.out.println(HEADER_TABLE);
        for (StatisticalInfo i : this.values()) {
            System.out.printf("| %-16s | %-23d | %-12.2f |\n",
                    i.getMountainCode(),
                    i.getNumOfStudent(),
                    i.getTotalCost());
        }
        System.out.println(FOOTER_TABLE);
    }
    
    // Function 7:
//    public void statisticalizeByMountainPeak() {
//        if (listStudent == null || listStudent.isEmpty()) {
//            System.out.println("No registration records found.");
//            return;
//        }
//        // Reset dữ liệu
//        mountainPeek.clear();
//        for (Student student : listStudent) {
//            String mountainCode = student.getMountainCode();
//            double tuitionFee = student.getTutionFee();
//
//            if (mountainPeek.containsKey(mountainCode)) {
//                StatisticalInfo peak = mountainPeek.get(mountainCode);
//                peak.setNumOfStudent(peak.getNumOfStudent()+ 1);
//                peak.setTotalCost(peak.getTotalCost() + tuitionFee);
//            } else {
//                mountainPeek.put(mountainCode, new StatisticalInfo(1, tuitionFee));
//            }
//        }
//        displayStatistic();
//    }
//
//    public void displayStatistic() {
//        System.out.println("Statistics of Registration by Mountain Peak:");
//        System.out.println("-------------------------------------------------------");
//        System.out.println("| Peak Name  | Number of Participants | Total Cost    |");
//        System.out.println("-------------------------------------------------------");
//        for (Map.Entry<String, StatisticalInfo> entry : mountainPeek.entrySet()) {
//            System.out.println(String.format("| %-10s | %-22d | %-13.2f |",
//                    entry.getKey(),
//                    entry.getValue().getNumOfStudent(),
//                    entry.getValue().getTotalCost()));
//        }
//        System.out.println("-------------------------------------------------------");
//        System.out.println();
//    }
}
