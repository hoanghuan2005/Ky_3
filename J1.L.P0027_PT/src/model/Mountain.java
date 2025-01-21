/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author SUPPER LOQ
 */
public class Mountain {

    private String mountainCode;
    private String mountain;
    private String province;
    private String description;

    public Mountain() {
    }

    public Mountain(String mountainCode, String mountain, String province, String description) {
        this.mountainCode = mountainCode;
        this.mountain = mountain;
        this.province = province;
        this.description = description;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        if (mountainCode != null && mountainCode.matches("\\d+")) {
            this.mountainCode = "MT" + String.format("%02d", Integer.parseInt(mountainCode));
        } else {
            this.mountainCode = mountainCode; // Giữ nguyên nếu không hợp lệ
        }
    }

    public String getMountain() {
        return mountain;
    }

    public void setMountain(String mountain) {
        this.mountain = mountain;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Mountain Code: " + mountainCode + ", Mountain: " + mountain + ", province: " + province + ", description: " + description;
    }
}
