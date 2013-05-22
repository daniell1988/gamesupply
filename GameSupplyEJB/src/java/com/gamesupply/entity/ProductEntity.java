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
 * @author CUESTAS
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductEntity.findAll", query = "SELECT p FROM ProductEntity p"),
    @NamedQuery(name = "ProductEntity.findByIdProduct", query = "SELECT p FROM ProductEntity p WHERE p.idProduct = :idProduct"),
    @NamedQuery(name = "ProductEntity.findByDescription", query = "SELECT p FROM ProductEntity p WHERE p.description = :description"),
    @NamedQuery(name = "ProductEntity.findByGenre", query = "SELECT p FROM ProductEntity p WHERE p.genre = :genre"),
    @NamedQuery(name = "ProductEntity.findByName", query = "SELECT p FROM ProductEntity p WHERE p.name = :name"),
    @NamedQuery(name = "ProductEntity.findByPlatform", query = "SELECT p FROM ProductEntity p WHERE p.platform = :platform"),
    @NamedQuery(name = "ProductEntity.findByPrice", query = "SELECT p FROM ProductEntity p WHERE p.price = :price"),
    @NamedQuery(name = "ProductEntity.findByType", query = "SELECT p FROM ProductEntity p WHERE p.type = :type")})
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
    @Column(name = "id_product")
    private Integer idProduct;
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
    @Size(max = 255)
    @Column(name = "type")
    private String type;

    public ProductEntity() {
    }

    public ProductEntity(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductEntity)) {
            return false;
        }
        ProductEntity other = (ProductEntity) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.ProductEntity[ idProduct=" + idProduct + " ]";
    }
    
}
