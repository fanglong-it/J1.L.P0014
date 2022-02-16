/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huy.management;

import huy.dto.Employee;
import huy.utils.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Fangl
 */
public class AssetFunction {

    private ArrayList<Employee> employees = new ArrayList<>();

    boolean isLogin = false;

    //1. loadFile
    public void readFile() {
        List<String> listLine = new ArrayList<>();
        try {
            FileReader fr = new FileReader("Employee.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            int i = 0;
            while ((line = br.readLine()) != null) {
                i++;
                String[] s = line.split(",");
                String id = s[0];
                String name = s[1];
                String birthdate = s[2];
                String role = s[3];
                String sex = s[4];
                String password = s[5];
                Employee employee = new Employee(birthdate, role, sex, password, id, name);
                employees.add(employee);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void login() {

        String id = util.getString("Input EmployeeId: \n", "Invalid Username", "^[a-zA-Z0-9\\s]*$");
        String password = util.getString("Input Password: \n", "Password Invalid", "^[a-zA-Z0-9\\s]*$");

        if(util.checkLogin(id, password, employees)){
            System.out.println("Login Success");
        }else{
            System.out.println("Invalid Username || Password!");
        }
    }

    public void printEmployee() {
        for (Employee employee : employees) {
            System.out.println("" + employee.toString());
        }
    }

}
