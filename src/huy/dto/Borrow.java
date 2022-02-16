/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huy.dto;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class Borrow {
    private String borrowId;
    private String assetId;
    private String employeeId;
    private int quanity;
    private Date borrowDate;

    public Borrow(String borrowId, String assetId, String employeeId, int quanity, Date borrowDate) {
        this.borrowId = borrowId;
        this.assetId = assetId;
        this.employeeId = employeeId;
        this.quanity = quanity;
        this.borrowDate = borrowDate;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
    
    
    
    
}
