/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CUESTAS
 */
@Entity
@Table(name = "sale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SaleEntity.findAll", query = "SELECT s FROM SaleEntity s"),
    @NamedQuery(name = "SaleEntity.findByIdSale", query = "SELECT s FROM SaleEntity s WHERE s.idSale = :idSale"),
    @NamedQuery(name = "SaleEntity.findByName", query = "SELECT s FROM SaleEntity s WHERE s.name = :name"),
    @NamedQuery(name = "SaleEntity.findByPlatform", query = "SELECT s FROM SaleEntity s WHERE s.platform = :platform"),
    @NamedQuery(name = "SaleEntity.findByType", query = "SELECT s FROM SaleEntity s WHERE s.type = :type"),
    @NamedQuery(name = "SaleEntity.findByPrice", query = "SELECT s FROM SaleEntity s WHERE s.price = :price"),
    @NamedQuery(name = "SaleEntity.findBySaleDate", query = "SELECT s FROM SaleEntity s WHERE s.saleDate = :saleDate"),
    @NamedQuery(name = "SaleEntity.findByBranch", query = "SELECT s FROM SaleEntity s WHERE s.branch = :branch"),
    @NamedQuery(name = "SaleEntity.findByQuantity", query = "SELECT s FROM SaleEntity s WHERE s.quantity = :quantity")})
public class SaleEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
    @Column(name = "id_sale")
    private Integer idSale;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "platform")
    private String platform;
    @Size(max = 255)
    @Column(name = "type")
    private String type;
    @Size(max = 255)
    @Column(name = "price")
    private String price;
    @Column(name = "sale_date", insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date saleDate;
    @Size(max = 255)
    @Column(name = "branch")
    private String branch;
    @Column(name = "quantity")
    private Integer quantity;

    public SaleEntity() {
    }

    public SaleEntity(Integer idSale) {
        this.idSale = idSale;
    }

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

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSale != null ? idSale.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaleEntity)) {
            return false;
        }
        SaleEntity other = (SaleEntity) object;
        if ((this.idSale == null && other.idSale != null) || (this.idSale != null && !this.idSale.equals(other.idSale))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.SaleEntity[ idSale=" + idSale + " ]";
    }
    
}
