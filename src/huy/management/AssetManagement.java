/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huy.management;

import huy.dto.Asset;
import huy.utils.util;
import java.util.ArrayList;
import javax.rmi.CORBA.Util;

/**
 *
 * @author Fangl
 */
public class AssetManagement {

    AssetFunction assetFunction = new AssetFunction();
    AssetMenu menu = new AssetMenu();
    

    public void management() {
        int choice;
        assetFunction.readFileEmployee();
        assetFunction.readFileAsset();
        do {
            menu.menuMain();
            choice = util.getAnInteger("Enter your choice from 1->8: ", "Please enter your choice from 1->8: ", 1, 8);
            switch (choice) {
                case 1:
//                    showRoom.readFile();
                    
                    assetFunction.login();
                    break;
                case 2:
                    String searchValue = util.getString("Input search Value:", "", "^[a-zA-Z0-9\\s]*$");
                    ArrayList<Asset> assets = assetFunction.searchAssetName(searchValue);
                    assetFunction.sortAssetByName(assets);
                    
                    break;
                case 3:
                    
                    assetFunction.createAsset();
//                    showRoom.updateVehicle();
                    break;
                case 4:
                    
                    assetFunction.updateAsset();
                    
//                    showRoom.deleteVehicle();
                    break;
                case 5:
//                    int choice5;
//                    do {
//                        menu.subMenuSearch();
//                        choice5 = util.getAnInteger("Enter your choice from 1->3: ", "Please enter your choice from 1->3: ", 1, 3);
//                        switch (choice5) {
//                            case 1:
//                               showRoom.searchVehicleByName();
//                                break;
//                            case 2:
//                                String id = util.getString("Input id vehicle CXXXXX(car) or MXXXXX(motorbike): ", "The format of id is EXXXXX(car) or VXXXXX(motorbike): ", "C\\d{5}|M\\d{5}");
//                                showRoom.searchVehicleByID(id);
//                                break;
//                            case 3:
//                                System.out.println("Quit");
//                                break;
//                        }
//                    } while (choice5 != 3);
                    break;
                case 6:
//                    int choice6;
//                    do {
//                        menu.subMenuShow();
//                        choice6 = util.getAnInteger("Enter your choice from 1->3: ", "Please enter your choice from 1->3: ", 1, 3);
//                        switch (choice6) {
//                            case 1:
//                                showRoom.showAll();
//                                break;
//                            case 2:
//                                showRoom.showAllVehicleDescendingByPrice();
//                                break;
//                            case 3:
//                                System.out.println("Quit");
//                                break;
//                        }
//                    } while (choice6 != 3);
                    break;
                case 7:
//                    showRoom.writeVehicle();
                    break;
                case 8:
//                    System.out.println("Bye-Bye");
                    break;
            }
        } while (choice != 8);
    }
}
