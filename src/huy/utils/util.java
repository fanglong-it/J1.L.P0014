/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huy.utils;

import huy.dto.Asset;
import huy.dto.Employee;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class util {

    private static Scanner sc = new Scanner(System.in);

    public static String getString(String inpuMsg, String errorMsg, String format) {
        String string;
        boolean match;
        while (true) {
            System.out.print(inpuMsg);
            string = sc.nextLine().trim();
            match = string.matches(format);
            if (string.length() == 0 || string.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return string;
            }
        }
    }

    public static double getAnDouble(String inputMsg, String errorMsg, double lowerBound, double upperBound) {
        double d;
        while (true) {
            try {
                System.out.print(inputMsg);
                d = Double.parseDouble(sc.nextLine());
                if (d < lowerBound || d > upperBound) {
                    throw new Exception();
                }
                return d;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int i;
        while (true) {
            try {
                System.out.print(inputMsg);
                i = Integer.parseInt(sc.nextLine());
                if (i < lowerBound || i > upperBound) {
                    throw new Exception();
                }
                return i;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static boolean checkLogin(String username, String password, ArrayList<Employee> employees) {
        boolean isCorrect = false;
        for (int i = 0; i < employees.size(); i++) {
            String id = employees.get(i).getId();
            String pass = employees.get(i).getPassword();
            if (id.equals(username) && pass.equals(password)) {
                isCorrect = true;
            }
        }
        return isCorrect;
    }

    public static Asset findAssetById(String id, ArrayList<Asset> assets) {
        Asset a = null;
        for (Asset asset : assets) {
            if (asset.getId().equals(id)) {
                a = asset;
            }
        }
        return a;
    }

    

    public static boolean checkAssetIdExist(String id, ArrayList<Asset> assets) {
        boolean exist = false;
        for (Asset asset : assets) {
            if (asset.getId().equals(id)) {
                exist = true;
            }
        }
        return exist;
    }

    public static void main(String[] args) {
        System.out.println("M12343".toUpperCase().matches("C\\d{5}|M\\d{5}"));
    }
}
