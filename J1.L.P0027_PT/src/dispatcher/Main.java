/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatcher;

import business.Mountains;
import business.Students;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import tools.Acceptable;
import tools.Inputter;
import tools.Menu;
import tools.Welcome;
import business.Statistics;

/**
 *
 * @author SUPPER LOQ
 */
public class Main {

    public static void main(String[] args) {

        Mountains mt = new Mountains();
        Students sts = new Students();
        Student st = new Student();
        Statistics sta = new Statistics();
        Inputter ip = new Inputter();

        Welcome.mainWelcome();

        sts.readFromFile();
        mt.readFromFile();

        int choice;
        boolean check = true;
        while (check) {
            Menu.mainMenu();
            choice = ip.getInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    sts.add(st);
                    sts.saveToFile();
                    break;
                case 2:
                    sts.update(st);
                    break;
                case 3:
                    sts.showAll();
                    break;
                case 4:
                    sts.delete(st.getId());
                    break;
                case 5:
                    sts.searchByName(st.getName());
                    break;
                case 6:
                    sts.filterByCampusCode(st.getId());
                    break;
                case 7:
                    sta.statisticalize(sts.getListStudent());
                    break;
                case 8:
                    sts.saveToFile();
                    break;
                case 9:
                    sts.exit();
                    return;
                default:
                    System.out.println("This function is not available.");
            }
        }
    }
}
