/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huy.dto;

import java.util.Comparator;

/**
 *
 * @author Fangl
 */
public class Asset extends Information implements Comparable<Asset> {

    private String color;
    private double price;
    private double weight;
    private int quantity;

    public Asset(String color, double price, double weight, int quantity, String id, String name) {
        super(id, name);
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    @Override
    public int compareTo(Asset t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Comparator<Asset> byName = new Comparator<Asset>() {
        @Override
        public int compare(Asset t, Asset t1) {

            if (t.getName().compareTo(t1.getName()) > 0) {
                return 1;
            } else if (t.getName().compareTo(t1.getName()) < 0) {
                return -1;
            }
            return 0;
        }
    };

    @Override
    public String toString() {
        return "Asset{" + "color=" + color + ", price=" + price + ", weight=" + weight + ", quantity=" + quantity + '}';
    }
    
    

}
