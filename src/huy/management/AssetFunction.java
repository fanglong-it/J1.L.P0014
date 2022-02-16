/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huy.management;

import huy.dto.Asset;
import huy.dto.Employee;
import huy.dto.Request;
import huy.utils.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Fangl
 */
public class AssetFunction {

    private ArrayList<Employee> employees = new ArrayList<>();

    private ArrayList<Asset> assets = new ArrayList<>();

    private ArrayList<Request> requests = new ArrayList<>();

    boolean isLogin = false;
    Scanner sc = new Scanner(System.in);

    //1. loadFile
    public void readFileEmployee() {
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

    public void readFileAsset() {
        List<String> listLine = new ArrayList<>();
        try {
            FileReader fr = new FileReader("Asset.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            int i = 0;
            while ((line = br.readLine()) != null) {
                i++;
                String[] s = line.split(",");
                String id = s[0];
                String name = s[1];
                String color = s[2];
                double price = Double.parseDouble(s[3]);
                double weight = Double.parseDouble(s[4]);
                int quantity = Integer.parseInt(s[5]);
                Asset asset = new Asset(color, price, weight, quantity, id, name);
                assets.add(asset);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readFileRequest() {
        List<String> list = new ArrayList<>();
        FileReader f = null;
        BufferedReader bf = null;
        try {
            f = new FileReader("Request.txt");
            bf = new BufferedReader(f);
            while (bf.ready()) {
                String s = bf.readLine();
                String[] a = s.split(",");
                String Rid = a[0];
                String Aid = a[1];
                String Eid = a[2];
                int quantity = Integer.parseInt(a[3]);
                String requestDateTime = a[4];

                Date requestDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(requestDateTime);
                Request request = new Request(Rid, Aid, Eid, quantity, requestDate);
                requests.add(request);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (bf != null) {
                    bf.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void login() {
        if (isLogin) {
            System.out.println("You Have been Login !!!");
        } else {

            String id = util.getString("Input EmployeeId: \n", "Invalid Username", "^[a-zA-Z0-9\\s]*$");
            String password = util.getString("Input Password: \n", "Password Invalid", "^[a-zA-Z0-9\\s]*$");

            if (util.checkLogin(id, password, employees)) {
                System.out.println("Login Success");
                isLogin = true;
            } else {
                System.out.println("Invalid Username || Password!");
            }
        }

    }

    public ArrayList<Asset> searchAssetName(String name) {
        ArrayList<Asset> tmpAssets = new ArrayList();
        for (Asset asset : assets) {
            if (asset.getName().contains(name)) {
                tmpAssets.add(asset);
            }
        }
        return tmpAssets;
    }

    public void sortAssetByName(ArrayList<Asset> assets) {
        Collections.sort(assets, Asset.byName);
        for (Asset asset : assets) {
            System.out.println(asset.toString());
        }
    }

    public void createAsset() {
        if (isLogin) {
            boolean check = true;

            boolean cont = true;
            String id = "";
            while (cont) {
                id = util.getString("Input Asset Id: ", "Must Match the format", "A\\d{3}");
                if (util.checkAssetIdExist(id, assets)) {
                    System.out.println("The Asset Id Is Exist");
                    cont = true;
                } else {
                    cont = false;
                }
            }

            String name = util.getString("Input Asset name:", "Must Match the format", "^[a-zA-Z0-9\\s]*$");
            String color = util.getString("Input Asset color:", "Must Match the format", "^[a-zA-Z0-9\\s]*$");
            Double price = util.getAnDouble("Input Asset Price:", "Must Match the format", 0.0, 1000);
            Double weight = util.getAnDouble("Input Weight:", "Must Match the format", 0.0, 100);
            int quantity = util.getAnInteger("Input Quantity:", "Must Match the format", 0, 1000);
            Asset asset = new Asset(color, price, weight, quantity, id, name);
            assets.add(asset);
            writeFileAsset();
        } else {
            System.out.println("You must to login!!!!");
        }

    }

    public void updateAsset() {
        if (isLogin) {
            while (true) {
                try {
                    String id = util.getString("Input Asset id: ", "The Format", "A\\d{3}");
                    if (id.isEmpty()) {
                        throw new Exception("Require enter the asset’s id");
                    }
                    Asset dto = util.findAssetById(id, assets);
                    if (dto != null) {
                        try {
                            sc = new Scanner(System.in);
                            System.out.println("Enter new Color: ");
                            String color = sc.nextLine();
                            color = color.isEmpty() ? dto.getColor() : color;

                            sc = new Scanner(System.in);
                            System.out.println("Enter new Price: ");
                            String price = sc.nextLine();
                            price = price.isEmpty() ? dto.getPrice() + "" : price;

                            sc = new Scanner(System.in);
                            System.out.println("Enter new Weight: ");
                            String weight = sc.nextLine();
                            weight = weight.isEmpty() ? dto.getWeight() + "" : weight;

                            sc = new Scanner(System.in);
                            System.out.println("Enter new Quantity: ");
                            String quantity = sc.nextLine();
                            quantity = quantity.isEmpty() ? dto.getQuantity() + "" : quantity;

                            sc = new Scanner(System.in);
                            System.out.println("Enter new Name: ");
                            String name = sc.nextLine();
                            name = name.isEmpty() ? dto.getName() : name;

                            Asset newAsset = new Asset(color, Double.parseDouble(price), Double.parseDouble(weight), Integer.parseInt(quantity), id, name);

                            if (updateAssetbyID(newAsset)) {
                                System.out.println("Update Successful!!!!!!!");
                            }
                            writeFileAsset();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else if (dto == null) {
                        System.out.println("Asset does not exist!");
                    }
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("You must be login");
        }
    }

    //Using Id to Update;
    public boolean updateAssetbyID(Asset newAsset) {
        boolean result = false;
        for (Asset a : assets) {
            if (a.getId().equals(newAsset.getId())) {
                a.setColor(newAsset.getColor());
                a.setPrice(newAsset.getPrice());
                a.setQuantity(newAsset.getQuantity());
                a.setWeight(newAsset.getWeight());
                a.setName(newAsset.getName());
                result = true;
            }
        }
        return result;
    }

    public boolean writeFileAsset() {
        if (assets == null) {
            return false;
        }
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("Asset.txt");
            for (Asset asset : assets) {
                pw.write(asset.getId() + ","
                        + asset.getName() + ","
                        + asset.getColor() + ","
                        + asset.getPrice() + ","
                        + asset.getWeight() + ","
                        + asset.getQuantity()
                );
                pw.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public void approveEmployeeRequest() {
        for (Request request : requests) {
            request.toString();
        }

        String requestId = util.getString("Input Request You Want to Approve", "Must match The format", "R\\d{3}");

    }

}
