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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "wishlist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WishlistEntity.findAll", query = "SELECT w FROM WishlistEntity w"),
    @NamedQuery(name = "WishlistEntity.findByIdProduct", query = "SELECT w FROM WishlistEntity w WHERE w.idProduct = :idProduct"),
    @NamedQuery(name = "WishlistEntity.findByBranch1", query = "SELECT w FROM WishlistEntity w WHERE w.branch1 = :branch1"),
    @NamedQuery(name = "WishlistEntity.findByBranch2", query = "SELECT w FROM WishlistEntity w WHERE w.branch2 = :branch2"),
    @NamedQuery(name = "WishlistEntity.findByBranch3", query = "SELECT w FROM WishlistEntity w WHERE w.branch3 = :branch3"),
    @NamedQuery(name = "WishlistEntity.findByDescription", query = "SELECT w FROM WishlistEntity w WHERE w.description = :description"),
    @NamedQuery(name = "WishlistEntity.findByGenre", query = "SELECT w FROM WishlistEntity w WHERE w.genre = :genre"),
    @NamedQuery(name = "WishlistEntity.findByName", query = "SELECT w FROM WishlistEntity w WHERE w.name = :name"),
    @NamedQuery(name = "WishlistEntity.findByPlatform", query = "SELECT w FROM WishlistEntity w WHERE w.platform = :platform"),
    @NamedQuery(name = "WishlistEntity.findByPrice", query = "SELECT w FROM WishlistEntity w WHERE w.price = :price"),
    @NamedQuery(name = "WishlistEntity.findByType", query = "SELECT w FROM WishlistEntity w WHERE w.type = :type")})
public class WishlistEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_product")
    private Integer idProduct;
    @Column(name = "branch1")
    private Integer branch1;
    @Column(name = "branch2")
    private Integer branch2;
    @Column(name = "branch3")
    private Integer branch3;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Size(max = 255)
    @Column(name = "type")
    private String type;

    public WishlistEntity() {
    }

    public WishlistEntity(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getBranch1() {
        return branch1;
    }

    public void setBranch1(Integer branch1) {
        this.branch1 = branch1;
    }

    public Integer getBranch2() {
        return branch2;
    }

    public void setBranch2(Integer branch2) {
        this.branch2 = branch2;
    }

    public Integer getBranch3() {
        return branch3;
    }

    public void setBranch3(Integer branch3) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof WishlistEntity)) {
            return false;
        }
        WishlistEntity other = (WishlistEntity) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.WishlistEntity[ idProduct=" + idProduct + " ]";
    }
    
}
