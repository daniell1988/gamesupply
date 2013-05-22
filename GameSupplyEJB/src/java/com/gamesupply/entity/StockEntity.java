/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cuestas
 */
@Entity
@Table(name = "stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StockEntity.findAll", query = "SELECT s FROM StockEntity s"),
    @NamedQuery(name = "StockEntity.findByIdProduct", query = "SELECT s FROM StockEntity s WHERE s.idProduct = :idProduct"),
    @NamedQuery(name = "StockEntity.findByBranch1", query = "SELECT s FROM StockEntity s WHERE s.branch1 = :branch1"),
    @NamedQuery(name = "StockEntity.findByBranch2", query = "SELECT s FROM StockEntity s WHERE s.branch2 = :branch2"),
    @NamedQuery(name = "StockEntity.findByBranch3", query = "SELECT s FROM StockEntity s WHERE s.branch3 = :branch3"),
    @NamedQuery(name = "StockEntity.findByDescription", query = "SELECT s FROM StockEntity s WHERE s.description = :description"),
    @NamedQuery(name = "StockEntity.findByGenre", query = "SELECT s FROM StockEntity s WHERE s.genre = :genre"),
    @NamedQuery(name = "StockEntity.findByName", query = "SELECT s FROM StockEntity s WHERE s.name = :name"),
    @NamedQuery(name = "StockEntity.findByPlatform", query = "SELECT s FROM StockEntity s WHERE s.platform = :platform"),
    @NamedQuery(name = "StockEntity.findByPrice", query = "SELECT s FROM StockEntity s WHERE s.price = :price")})
public class StockEntity implements Serializable {
    @Size(max = 255)
    @Column(name = "type")
    private String type;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
    @Column(name = "id_product")
    private Integer idProduct;
    @Size(max = 255)
    @Column(name = "branch1")
    private String branch1;
    @Size(max = 255)
    @Column(name = "branch2")
    private String branch2;
    @Size(max = 255)
    @Column(name = "branch3")
    private String branch3;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "genre")
    private String genre;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "platform")
    private String platform;
    @Size(max = 255)
    @Column(name = "price")
    private String price;

    public StockEntity() {
    }

    public StockEntity(Integer idProduct) {
        this.idProduct = idProduct;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockEntity)) {
            return false;
        }
        StockEntity other = (StockEntity) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.StockEntity[ idProduct=" + idProduct + " ]";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
