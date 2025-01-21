/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mountain;
import model.Student;
import tools.Acceptable;

/**
 *
 * @author SUPPER LOQ
 */
public class Mountains {

    private String pathFile = "D:\\Ky-3,4-SP25\\LAB211\\J1.L.P0027\\MountainList.csv";
    private List<Mountain> mountainList;

    public Mountains() {
//        this.mountainList.add(e)
    }

    public Mountains(String pathFile, List<Mountain> mountainList) {
        this.pathFile = pathFile;
        this.mountainList = mountainList;
    }

    public Mountain get(String mountainCode) {
        if (isValidMountainCode(mountainCode)) {
            readFromFile();
            for (Mountain m : mountainList) {
                if (m.getMountainCode().equalsIgnoreCase(mountainCode)) {
                    return m;
                }
            }
        }

        return null;
    }

    public boolean isValidMountainCode(String mountainCode) {
        return Acceptable.MOUNTAIN_VALID.contains(mountainCode);
    }

    public Mountain dataToObject(String text) {
        String[] parts = text.split(",");
        if (parts.length == 4) {
            return new Mountain(parts[0], parts[1], parts[2], parts[3]);
        }
        return null;
    }

    public void readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.pathFile))) {
            if (mountainList == null) {
                mountainList = new ArrayList<>();
            }

            String line;
            while ((line = br.readLine()) != null) {
                Mountain mountain = dataToObject(line);
                if (mountain != null) {
                    mountainList.add(mountain);
                }
            }
            System.out.println("Data successfully loaded from file: " + this.pathFile);
        } catch (FileNotFoundException e) {
            Logger.getLogger(Mountains.class.getName()).log(Level.SEVERE, "File not found: " + this.pathFile, e);
        } catch (IOException e) {
            Logger.getLogger(Mountains.class.getName()).log(Level.SEVERE, "Error reading file: " + this.pathFile, e);
        }
        showAll();
    }
    
    public void showAll() {
        showAll(mountainList);
    }

    public void showAll(List<Mountain> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Mountain mountain : list) {
            System.out.println(mountain);
        }
        System.out.println();
    }
}
