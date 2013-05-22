/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.dto;

import java.io.Serializable;

/**
 *
 * @author cuestas
 */
public class StockDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Integer idProduct;
    private String branch1;
    private String branch2;
    private String branch3;
    private String description;
    private String genre;
    private String name;
    private String platform;
    private String price;
    private String type;
    
    public StockDTO(){
        
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getBranch1() {
        return branch1;
    }

    public void setBranch1(String branch1) {
        this.branch1 = branch1;
    }

    public String getBranch2() {
        return branch2;
    }

    public void setBranch2(String branch2) {
        this.branch2 = branch2;
    }

    public String getBranch3() {
        return branch3;
    }

    public void setBranch3(String branch3) {
        this.branch3 = branch3;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    
    
}
