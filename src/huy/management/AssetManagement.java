/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huy.management;

import huy.utils.util;
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
        assetFunction.readFile();

        do {
            menu.menuMain();
            choice = util.getAnInteger("Enter your choice from 1->8: ", "Please enter your choice from 1->8: ", 1, 8);
            switch (choice) {
                case 1:
//                    showRoom.readFile();
                    
                    assetFunction.login();
                    break;
                case 2:
//                    int choice2;
//                    do {
//                        menu.addVehicle();
//                        choice2 = util.getAnInteger("Enter your choice from 1->3: ", "Please enter your choice from 1->3: ", 1, 3);
//                        switch (choice2) {
//                            case 1:
//                                showRoom.addVehicle(1);
//                                break;
//                            case 2:
//                                showRoom.addVehicle(2);
//                                break;
//                            case 3:
//                                System.out.println("Quit");
//                                break;
//                        }
//                    } while (choice2 != 3);
                    assetFunction.printEmployee();
                    break;
                case 3:
//                    showRoom.updateVehicle();
                    break;
                case 4:
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
