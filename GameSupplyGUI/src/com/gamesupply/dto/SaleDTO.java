/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author CUESTAS
 */
public class SaleDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer idSale;
    private String name;
    private String platform;
    private String type;
    private String price;
    private Date saleDate;
    private String branch;
    private Integer quantity;

    public Integer getIdSale() {
        return idSale;
    }

    public void setIdSale(Integer idSale) {
        this.idSale = idSale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getDate() {
        return saleDate;
    }

    public void setDate(Date date) {
        this.saleDate = date;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    
    
}
