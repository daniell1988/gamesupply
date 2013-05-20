/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CUESTAS
 */
@Entity
@Table(name = "stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StockEntity.findAll", query = "SELECT s FROM StockEntity s"),
    @NamedQuery(name = "StockEntity.findByIdProduct", query = "SELECT s FROM StockEntity s WHERE s.idProduct = :idProduct"),
    @NamedQuery(name = "StockEntity.findByBranch", query = "SELECT s FROM StockEntity s WHERE s.branch = :branch"),
    @NamedQuery(name = "StockEntity.findByQuantity", query = "SELECT s FROM StockEntity s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "StockEntity.findByName", query = "SELECT s FROM StockEntity s WHERE s.name = :name"),
    @NamedQuery(name = "StockEntity.findByGenre", query = "SELECT s FROM StockEntity s WHERE s.genre = :genre"),
    @NamedQuery(name = "StockEntity.findByPlatform", query = "SELECT s FROM StockEntity s WHERE s.platform = :platform"),
    @NamedQuery(name = "StockEntity.findByDescription", query = "SELECT s FROM StockEntity s WHERE s.description = :description"),
    @NamedQuery(name = "StockEntity.findByPrice", query = "SELECT s FROM StockEntity s WHERE s.price = :price")})
public class StockEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_product")
    private Integer idProduct;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "branch")
    private String branch;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "genre")
    private String genre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "platform")
    private String platform;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "price")
    private String price;
    @JoinColumn(name = "id_product", referencedColumnName = "id_product", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ProductEntity productEntity;

    public StockEntity() {
    }

    public StockEntity(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public StockEntity(Integer idProduct, String branch, int quantity, String name, String genre, String platform, String description, String price) {
        this.idProduct = idProduct;
        this.branch = branch;
        this.quantity = quantity;
        this.name = name;
        this.genre = genre;
        this.platform = platform;
        this.description = description;
        this.price = price;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
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
    
}
