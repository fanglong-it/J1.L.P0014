/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huy.dto;

import java.util.Date;

/**
 *
 * @author Fangl
 */
public class Request {
    private String requestId;
    private String assetId;
    private String employeeId;
    private int quantity;
    private Date requestDate;

    public Request(String requestId, String assetId, String employeeId, int quantity, Date requestDate) {
        this.requestId = requestId;
        this.assetId = assetId;
        this.employeeId = employeeId;
        this.quantity = quantity;
        this.requestDate = requestDate;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
    
    
}
