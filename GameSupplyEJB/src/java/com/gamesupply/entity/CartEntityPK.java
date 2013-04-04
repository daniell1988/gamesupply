/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author CUESTAS
 */
@Embeddable
public class CartEntityPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_costumer")
    private int idCostumer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product_item")
    private int idProductItem;

    public CartEntityPK() {
    }

    public CartEntityPK(int idCostumer, int idProductItem) {
        this.idCostumer = idCostumer;
        this.idProductItem = idProductItem;
    }

    public int getIdCostumer() {
        return idCostumer;
    }

    public void setIdCostumer(int idCostumer) {
        this.idCostumer = idCostumer;
    }

    public int getIdProductItem() {
        return idProductItem;
    }

    public void setIdProductItem(int idProductItem) {
        this.idProductItem = idProductItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCostumer;
        hash += (int) idProductItem;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartEntityPK)) {
            return false;
        }
        CartEntityPK other = (CartEntityPK) object;
        if (this.idCostumer != other.idCostumer) {
            return false;
        }
        if (this.idProductItem != other.idProductItem) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.CartEntityPK[ idCostumer=" + idCostumer + ", idProductItem=" + idProductItem + " ]";
    }
    
}
