/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huy.management;

import huy.dto.Asset;
import huy.utils.util;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class AssetManagement {

    AssetFunction assetFunction = new AssetFunction();
    AssetMenu menu = new AssetMenu();

    public void management() {
        int choice;
        assetFunction.readFileEmployee();
        assetFunction.readFileAsset();
        assetFunction.readFileRequest();
        do {
            menu.menuMain();
            choice = util.getAnInteger("Enter your choice from 1->8: ", "Please enter your choice from 1->8: ", 1, 8);
            switch (choice) {
                case 1:
                    assetFunction.login();
                    break;
                case 2:
                    String searchValue = util.getString("Input search Value:", "", "^[a-zA-Z0-9\\s]*$");
                    ArrayList<Asset> assets = assetFunction.searchAssetName(searchValue);
                    assetFunction.sortAssetByName(assets);

                    break;
                case 3:
                    assetFunction.createAsset();
                    break;
                case 4:
                    assetFunction.updateAsset();
                    break;
                case 5:
                    assetFunction.approveEmployeeRequest();
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("Bye-Bye");
                    break;
            }
        } while (choice != 8);
    }
}
