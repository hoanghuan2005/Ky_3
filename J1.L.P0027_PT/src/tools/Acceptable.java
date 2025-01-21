/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
/**
 *
 * @author SUPPER LOQ
 */
public interface Acceptable {
    public static final String STUDENT_ID = "^[CcDdHhSsQq][Ee]\\d{6}$";
    public static final String CAMPUS_ID = "^[CcDdHhSsQq][Ee]";
    public static final String NAME_VALID = "^[^(.|!@#$%^&*())]{2,20}$";
    public static final String DOUBLE_VALID = "^\\d+(\\.\\d+)?$";
    public static final String INTEGER_VALID = "\\d+";
    public static final String PHONE_VALID = "\\d{10}";
    public static final String VIETTEL_VALID = "^(086|096|097|098|03[2-9])\\d{7}$";
    public static final String VNPT_VALID = "^(081|082|083|084|085|088|091|094)\\d{7}$";
    public static final String EMAIL_VALID = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final String Y_N_VALID = "^[YyNn]$";
    public static final String MOUNTAIN_VALID = "^[1-13]$";

    public static boolean isValid(String data, String pattern) {
        return data != null && data.matches(pattern);
    }
}
