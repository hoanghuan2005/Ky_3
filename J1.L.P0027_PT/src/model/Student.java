/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author SUPPER LOQ
 */
public class Student implements Serializable{

    private String id;
    private String name;
    private String phone;
    private String email;
    private String mountainCode;
    private double tutionFee;

    public Student() {
    }

    public Student(String id, String name, String phone, String email, String mountainCode, double tutionFee) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.mountainCode = mountainCode;
        this.tutionFee = tutionFee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        if (mountainCode != null && mountainCode.matches("\\d+")) {
            this.mountainCode = "MT" + String.format("%02d", Integer.parseInt(mountainCode));
        } else {
            this.mountainCode = mountainCode;
        }
    }

    public double getTutionFee() {
        return tutionFee;
    }

    public void setTutionFee(double tutionFee) {
        this.tutionFee = tutionFee;
    }

    @Override
    public String toString() {
        return String.format("| %-12s | %-15s | %-15s | %-25s | %-11s | %-12s |",
                truncateOrPad(id, 12),
                truncateOrPad(name, 15),
                truncateOrPad(phone, 15),
                truncateOrPad(email, 25),
                truncateOrPad(mountainCode, 11),
                truncateOrPad(String.format("%.2f", tutionFee), 12));
    }
    
    // Hàm hỗ trợ để cắt chuỗi hoặc điền thêm khoảng trắng
    private String truncateOrPad(String value, int length) {
        if (value == null) {
            value = ""; // Xử lý null
        }
        if (value.length() > length) {
            return value.substring(0, length); // Cắt chuỗi
        }
        return String.format("%-" + length + "s", value); // Điền thêm khoảng trắng
    }
}
