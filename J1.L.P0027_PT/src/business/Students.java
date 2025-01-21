/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.Statistics;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mountain;
import model.StatisticalInfo;
import model.Student;
import tools.Acceptable;
import tools.Inputter;
import tools.MenuUpdate;

/**
 *
 * @author SUPPER LOQ
 */
public class Students {

    // Map Lưu thông tin
    public Mountains mt;
    public Inputter ip = new Inputter();
    private List<Student> listStudent;
    private String pathFile = "D:\\Ky-3,4-SP25\\LAB211\\J1.L.P0027\\registrations\\Registration.dat";
    private boolean isSaved;

    public Students() {
        this.listStudent = new ArrayList<>();
//        listStudent.add(new Student("SE192248", "Huan", "0335504305", "hoang@gmail.com", "001", 6000000.0));
//        listStudent.add(new Student("HE192249", "Lan", "0335504306", "lan@gmail.com", "002", 5800000.0));
//        listStudent.add(new Student("CE192250", "Minh", "0335504307", "minh@gmail.com", "003", 6100000.0));
//        listStudent.add(new Student("QE192251", "Hoa", "0335504308", "hoa@gmail.com", "004", 6200000.0));
//        listStudent.add(new Student("SE192252", "Phuc", "0335504309", "phuc@gmail.com", "005", 5900000.0));
//        listStudent.add(new Student("DE192253", "Duy", "0335504310", "duy@gmail.com", "006", 6000000.0));
//        readFromFile();
    }

    public boolean isSaved() {
        return isSaved;
    }

    // hàm trả về danh sách sinh viên
    public List<Student> getListStudent() {
        return this.listStudent;
    }

    public void add(Student student) {
        if (listStudent == null) {
            listStudent = new ArrayList<>();
        }
        System.out.println("Add a new student registration.");
        String id = ip.inputAndLoop("Enter ID: ", Acceptable.STUDENT_ID);

        if (searchById(id) == null) {
            Student x = new Student();
            x.setId(id);
            x.setName(ip.inputAndLoop("Enter NAME: ", Acceptable.NAME_VALID));
            x.setPhone(ip.inputAndLoop("Enter PHONE: ", Acceptable.PHONE_VALID));
            x.setEmail(ip.inputAndLoop("Enter EMAIL: ", Acceptable.EMAIL_VALID));
            String temp = ip.inputAndLoop("Enter MOUNTAIN CODE (Please input from 1 to 13): ", Acceptable.INTEGER_VALID);
            if (mt.isValidMountainCode(temp)) {
                Mountain mountain = mt.get(temp);
                x.setMountainCode(mountain.getMountainCode());
            }
            
            double tuitionFee = 6000000.0;
            // lay 3 so dau
            String phone = x.getPhone().substring(0, 3);
            if (Acceptable.VIETTEL_VALID.contains(phone) || Acceptable.VNPT_VALID.contains(phone)) {
                tuitionFee *= 0.65;
                System.out.println("Chúc mừng! Số điện thoại của bạn được giảm giá 35%.");
            }
            x.setTutionFee(tuitionFee);

            listStudent.add(x);
            saveToFile();
            this.isSaved = false;
            System.out.println("Student added successfully !!!");
        } else {
            System.out.println("Student with ID " + id + " already exists!");
        }
    }

    // Function 2:
    public void update(Student x) {
        String id = ip.inputAndLoop("Enter student ID to update: ", Acceptable.STUDENT_ID);
        Student est = searchById(id);
        if (est != null) {
            int choose;
            boolean check = true;
            while (check) {
                MenuUpdate.menuUpdate();
                choose = ip.getInt("Enter your choice: ");
                switch (choose) {
                    case 1:
                        est.setName(ip.inputAndLoop("Enter NAME: ", Acceptable.NAME_VALID));
                        break;
                    case 2:
                        est.setPhone(ip.inputAndLoop("Enter PHONE: ", Acceptable.PHONE_VALID));
                        double tuitionFee = 6000000.0;
                        // lay 3 so dau
                        String phone = est.getPhone().substring(0, 3);
                        if (Acceptable.VIETTEL_VALID.contains(phone) || Acceptable.VNPT_VALID.contains(phone)) {
                            tuitionFee *= 0.65;
                        }
                        est.setTutionFee(tuitionFee);
                        break;
                    case 3:
                        est.setEmail(ip.inputAndLoop("Enter EMAIL: ", Acceptable.EMAIL_VALID));
                        break;
                    case 4:
                        est.setMountainCode(ip.inputAndLoop("Enter MOUNTAIN CODE: ", Acceptable.MOUNTAIN_VALID));
                        break;
                    case 5:
                        est.setName(ip.inputAndLoop("Enter NAME: ", Acceptable.NAME_VALID));
                        est.setPhone(ip.inputAndLoop("Enter PHONE: ", Acceptable.PHONE_VALID));
                        est.setEmail(ip.inputAndLoop("Enter EMAIL: ", Acceptable.EMAIL_VALID));
                        est.setMountainCode(ip.inputAndLoop("Enter MOUNTAIN CODE: ", Acceptable.MOUNTAIN_VALID));
                        System.out.println("Update successfully !!!");
                        break;
                    default:
                        return;
                }
            }
        } else {
            System.out.println("This student has not registered yet.");
        }
    }

    public void delete(String id) {
        id = ip.inputAndLoop("Enter student ID to delete: ", Acceptable.STUDENT_ID);
        Student st = searchById(id);
        if (st != null) {
            detail(st);
            String text = ip.getString("Are you sure you want to delete this registration? (Y/N): ");
            if (text.equalsIgnoreCase("Y")) {
                listStudent.remove(st);
                System.out.println("The registration has been successfully deleted.");
            } else {
                return;
            }
            isSaved = false;
        } else {
            System.out.println("This student has not registered yet.");
        }
    }

    // Hàm chi tiết sinh viên
    public void detail(Student x) {
        System.out.println("Student Detail:");
        System.out.println("----------------------------");
        System.out.println("Studenr ID: " + x.getId());
        System.out.println("Name      : " + x.getName());
        System.out.println("Phone     : " + x.getPhone());
        System.out.println("Mountain  : " + x.getMountainCode());
        System.out.println("Fee       : " + x.getTutionFee());
        System.out.println("----------------------------");
    }

    // tìm kiếm student theo id
    public Student searchById(String id) {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }

    public void searchByName(String name) {
        name = ip.inputAndLoop("Enter student Name to search: ", Acceptable.NAME_VALID);
        if (name != null) {
            List<Student> rs = new ArrayList<>();
            for (Student student : listStudent) {
                if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                    rs.add(student);
                }
            }
            showAll(rs);
        } else {
            System.out.println("No one matches the search criteria!");
        }
    }

    // Function 6:
    public List<Student> filterByCampusCode(String campusCode) {
        campusCode = ip.inputAndLoop("Input: ", Acceptable.CAMPUS_ID);
        String text = findCampus(campusCode);
        if (campusCode != null && !campusCode.isEmpty()) {
            System.out.println("Registered Students Under " + text + " Campus (" + campusCode + "):");
            List<Student> rs = new ArrayList<>();
            boolean found = false;
            for (Student student : listStudent) {
                if (student.getId().length() >= 2 && student.getId().substring(0, 2).equalsIgnoreCase(campusCode)) {
                    rs.add(student);
                    found = true;
                }
            }
            showAll(rs);
            if (!found) {
                System.out.println("No students have registered under this campus.");
            }
        }
        return null;
    }

    public String findCampus(String campusCode) {
        if (campusCode.equalsIgnoreCase("SE")) {
            return "Ho Chi Minh";
        } else if (campusCode.equalsIgnoreCase("CE")) {
            return "Can Tho";
        } else if (campusCode.equalsIgnoreCase("DE")) {
            return "Da Nang";
        } else if (campusCode.equalsIgnoreCase("HE")) {
            return "Ha Noi";
        } else {
            return "Quy Nhon";
        }
    }

    
    // Function 3:
    public void showAll() {
        showAll(listStudent);
    }

    public void showAll(List<Student> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("| Student ID   | Name            | Phone           | Email                     | Peek Code   | Fee          |");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        for (Student student : list) {
            System.out.println(student);
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    // Function 8:
    public void saveToFile() {

        if (this.isSaved) {
            return;
        }
        try {
            File f = new File(this.pathFile);
            FileOutputStream fos = null;
            // tạo file outpúttream ánh xạ đến File Object
            fos = new FileOutputStream(f);
            // Tạo objectoutpúttream để chuyển dữ liệu xuống thiết bị
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // 4. Lặp để ghi dữ liệu
            for (Student student : listStudent) {
                oos.writeObject(student);
            }

            oos.close();
            // cập nhật trang thái file
            this.isSaved = true;
            System.out.println("Registration data has been successfully saved to '" + this.pathFile + "'.");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readFromFile() {
        FileInputStream fis = null;
        try {
            File f = new File(this.pathFile);
            if (!f.exists()) {
                System.out.println("Registration.dat file is not found !.");
                return;
            }
            fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            if (listStudent == null) {
                listStudent = new ArrayList<>();
            }

            while (fis.available() > 0) {
                Student x = (Student) ois.readObject();
                listStudent.add(x);
            }

            // Dong object sau ki doc xong
            ois.close();
            this.isSaved = true;
        } catch (FileNotFoundException e) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception e) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    // Function 9:
    public void exit(){
        if (!isSaved) {
            System.out.println();
            String text = ip.inputAndLoop("Do you want to save the changes before exiting? (Y/N): ", Acceptable.Y_N_VALID);
            if (text.equalsIgnoreCase("Y")) {
                saveToFile();
            }else{
                return;
            }
        }
        return;
    }

}
