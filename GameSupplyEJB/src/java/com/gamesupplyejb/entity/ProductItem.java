/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupplyejb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CUESTAS
 */
@Entity
@Table(name = "product_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductItem.findAll", query = "SELECT p FROM ProductItem p"),
    @NamedQuery(name = "ProductItem.findByIdProductItem", query = "SELECT p FROM ProductItem p WHERE p.idProductItem = :idProductItem")})
public class ProductItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product_item")
    private Integer idProductItem;

    public ProductItem() {
    }

    public ProductItem(Integer idProductItem) {
        this.idProductItem = idProductItem;
    }

    public Integer getIdProductItem() {
        return idProductItem;
    }

    public void setIdProductItem(Integer idProductItem) {
        this.idProductItem = idProductItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductItem != null ? idProductItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductItem)) {
            return false;
        }
        ProductItem other = (ProductItem) object;
        if ((this.idProductItem == null && other.idProductItem != null) || (this.idProductItem != null && !this.idProductItem.equals(other.idProductItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupplyejb.entity.ProductItem[ idProductItem=" + idProductItem + " ]";
    }
    
}
